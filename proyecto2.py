from prettytable.prettytable import NONE
from antlr4 import *
from antlr4.tree.Trees import TerminalNode
from DecafLexer import DecafLexer
from DecafListener import DecafListener
from DecafParser import DecafParser
from itertools import groupby
from utilities import *

import sys

class DecafPrinter(DecafListener):
    def __init__(self):
        self.root = None
        
        self.STRING = 'char'
        self.INT = 'int'
        self.BOOLEAN = 'boolean'
        self.VOID = 'void'
        self.ERROR = 'error'

        self.data_type = {
            'char': self.STRING,
            'int': self.INT,
            'boolean': self.BOOLEAN,
            'void': self.VOID,
            'error': self.ERROR
        }

        self.ambitos = []
        self.current_scope = None
        self.tabla_tipos = TablaTipos()
        self.errores = SemanticError()
        self.tabla_methods = TablaMetodos()
        self.tabla_struct = TablaStruct()
        
        self.node_type = {}

        super().__init__()

    def PopScope(self):
        self.current_scope.ToTable()
        self.current_scope = self.ambitos.pop()        

    def NewScope(self):
        self.ambitos.append(self.current_scope)
        self.current_scope = TablaSimbolos()

    def Find(self, var):
        lookup = self.current_scope.LookUp(var)
        if lookup == 0:
            ambitos_reverse = self.ambitos.copy()
            ambitos_reverse.reverse()
            for scope in ambitos_reverse:
                lookup2 = scope.LookUp(var)
                if lookup2 != 0:
                    return lookup2
            return 0
        else:
            return lookup

    def Intersection(self, a, b):
        return [v for v in a if v in b]

    def all_equal(self, iterable):
        g = groupby(iterable)
        return next(g, True) and not next(g, False)

    def ChildrenHasError(self, ctx):
        non_terminals = [self.node_type[i] for i in ctx.children if type(i) in [DecafParser.LocationContext, DecafParser.ExprContext, DecafParser.BlockContext, DecafParser.DeclarationContext]]
        if self.ERROR in non_terminals:
            return True
        return False

    def enterProgram(self, ctx: DecafParser.ProgramContext):
        print('---------- INICIO --------------')
        self.root = ctx
        self.current_scope = TablaSimbolos()

    def enterMethod_declr(self, ctx: DecafParser.Method_declrContext):
        method = ctx.method_name().getText()
        parameters = []

        if self.tabla_methods.LookUp(method) == 0:
            if ctx.return_type().var_type() is not None:
                tipo = ctx.return_type().var_type().getText()
            else:
                tipo = ctx.return_type().getText()
            print('Entrando a metodo', method)
            hijos = ctx.getChildCount()

            for i in range(hijos):
                if isinstance(ctx.getChild(i), DecafParser.Var_typeContext):
                    typeParameter = self.data_type[ctx.getChild(i).getText()]
                    idParameter = ctx.getChild(i + 1).getText()
                    parameters.append({'Tipo': typeParameter, 'Id': idParameter})

            
            self.tabla_methods.Add(tipo, method, parameters, None)
        else:
            line = ctx.method_name().start.line
            col = ctx.method_name().start.column
            self.errores.Add(line, col, self.errores.IDENTIFICADOR_DECLARADO_MUCHAS_VECES)
        
        self.NewScope()

        for parameter in parameters:
            type_symbol = self.tabla_tipos.LookUp(parameter['Tipo'])
            size = type_symbol['Size']
            offset = self.current_scope._offset
            self.current_scope.Add(parameter['Tipo'], parameter['Id'], size, offset, True)

    def exitMethod_declr(self, ctx: DecafParser.Method_declrContext):
        method = ctx.method_name().getText()
        self.PopScope()

        return_type = ctx.return_type().getText()
        block_type = self.node_type[ctx.block()]

        if return_type == self.VOID and block_type != self.VOID and block_type != self.ERROR:
            self.node_type[ctx] = self.ERROR
            line = ctx.return_type().start.line
            col = ctx.return_type().start.column
            self.errores.Add(line, col, self.errores.RETURN_VOID)
            return

        if return_type != block_type:
            if block_type == self.ERROR:
                self.node_type[ctx] = self.ERROR
                return
            
            self.node_type[ctx] = self.ERROR
            line = ctx.block().start.line
            col = ctx.block().start.column
            self.errores.Add(line, col, self.errores.RETURN_TYPE)

        self.node_type[ctx] = self.VOID
        print('Saliendo metodo', method)

    def enterVardeclr(self, ctx: DecafParser.VardeclrContext):
        tipo = ctx.var_type().getText()

        # TOMAR EN CUENTA DECLARACION DE ARRAY'S
        if ctx.field_var().var_id() is not None:
            id = ctx.field_var().var_id().getText()

            # Si no encuentra una variable, la guarda en la tabla de simbolos
            # En caso contrario, ya está declarada, y eso es ERROR.
            if self.current_scope.LookUp(id) == 0:
                type_symbol = self.tabla_tipos.LookUp(tipo)
                size = type_symbol['Size']
                offset = self.current_scope._offset

                self.current_scope.Add(tipo, id, size, offset, False)
            else:
                self.node_type[ctx.field_var()] = self.ERROR
                line = ctx.field_var().var_id().start.line
                col = ctx.field_var().var_id().start.column
                self.errores.Add(line, col, self.errores.IDENTIFICADOR_DECLARADO_MUCHAS_VECES)
        elif ctx.field_var().array_id() is not None:
            id = ctx.field_var().array_id().getChild(0).getText()

            if self.current_scope.LookUp(id) == 0:
                tipo_array = 'array' + tipo
                size = 0

                if ctx.field_var().array_id().int_literal() is not None:
                    size = int(ctx.field_var().array_id().int_literal().getText())

                print('ARRAY DCLR', tipo_array, id, size)
                if 'struct' in tipo_array:
                    self.tabla_tipos.Add(tipo_array, size, self.tabla_tipos.ARRAY + self.tabla_tipos.STRUCT)
                else:
                    self.tabla_tipos.Add(tipo_array, size, self.tabla_tipos.ARRAY)

                type_symbol = self.tabla_tipos.LookUp(tipo_array)
                size = type_symbol['Size']
                offset = self.current_scope._offset

                self.current_scope.Add(tipo_array, id, size, offset, False)

            else:
                self.node_type[ctx.field_var()] = self.ERROR
                line = ctx.field_var().var_id().start.line
                col = ctx.field_var().var_id().start.column
                self.errores.Add(line, col, self.errores.IDENTIFICADOR_DECLARADO_MUCHAS_VECES)
            
    def enterStruct_declr(self, cstx: DecafParser.Struct_declrContext):
        self.NewScope()

    def exitStruct_declr(self, ctx: DecafParser.Struct_declrContext):
        tipo = ctx.getChild(0).getText() + ctx.getChild(1).getText()

        if self.tabla_tipos.LookUp(tipo) == 0:
            size_scope = self.current_scope.GetSize()
            self.tabla_tipos.Add(tipo, size_scope, self.tabla_tipos.STRUCT)
            self.tabla_struct.ExtractInfo(tipo, self.current_scope, self.tabla_tipos)
            self.PopScope()

            self.node_type[ctx] = self.VOID
            for child in ctx.children:
                if not isinstance(child, TerminalNode):
                    if self.node_type[child] == self.ERROR:
                        self.node_type[ctx] = self.ERROR
                        break
        else:
            self.node_type[ctx] = self.ERROR
            line = ctx.start.line
            col = ctx.start.column
            self.errores.Add(line, col, self.errores.IDENTIFICADOR_DECLARADO_MUCHAS_VECES)

    def exitVar_id(self, ctx: DecafParser.Var_idContext):
        parent = ctx.parentCtx
        if parent in self.node_type.keys():
            return

        # if ctx.getChildCount() == 1:
        id = ctx.getText()
        variable = self.Find(id)
        if variable == 0:
            line = ctx.start.line
            col = ctx.start.column
            self.errores.Add(line, col, f'Variable "{id}" no ha sido declarada previamente.')
            self.node_type[ctx] = self.ERROR
        else:
            if variable['Tipo'] in [self.INT, self.STRING, self.BOOLEAN]:
                self.node_type[ctx] = self.data_type[variable['Tipo']]
            else:
                self.node_type[ctx] = self.VOID
        # else:

    def exitArray_id(self, ctx: DecafParser.Array_idContext):
        parent = ctx.parentCtx
        if parent in self.node_type.keys():
            return

        id = ctx.getChild(0).getText()
        variable = self.Find(id)
        if variable == 0:
            line = ctx.start.line
            col = ctx.start.column
            self.errores.Add(line, col, f'Variable "{id}" no ha sido declarada previamente.')
            self.node_type[ctx] = self.ERROR
        else:
            tipo = variable['Tipo']
            if ctx.int_literal() is not None:
                if 'array' in tipo:
                    if tipo.split('array')[-1] in [self.INT, self.STRING, self.BOOLEAN]:
                        self.node_type[ctx] = self.data_type[tipo.split('array')[-1]]
                    else:
                        self.node_type[ctx] = self.VOID
                else:
                    line = ctx.start.line
                    col = ctx.start.column
                    self.errores.Add(line, col, f'Variable "{id}" debe ser un array.')
                    self.node_type[ctx] = self.ERROR
            elif ctx.var_id() is not None:
                tipo_var = self.Find(ctx.var_id().getText())
                print('TIPO VAR', tipo_var)
                if tipo_var == 0:
                    # line = ctx.start.line
                    # col = ctx.start.column
                    # self.errores.Add(line, col, f'Variable "{ctx.var_id().getText()}" no ha sido declarada previamente.')
                    self.node_type[ctx] = self.ERROR
                    return

                if 'array' in tipo and tipo_var['Tipo'] == self.INT:
                    if tipo.split('array')[-1] in [self.INT, self.STRING, self.BOOLEAN]:
                        self.node_type[ctx] = self.data_type[tipo.split('array')[-1]]
                    else:
                        self.node_type[ctx] = self.VOID
                elif 'array' not in tipo:
                    line = ctx.start.line
                    col = ctx.start.column
                    self.errores.Add(line, col, f'Variable "{id}" debe ser un array.')
                    self.node_type[ctx] = self.ERROR
                elif tipo_var['Tipo'] != self.INT:
                    line = ctx.start.line
                    col = ctx.start.column
                    self.errores.Add(line, col, f'Variable "{ctx.var_id().getText()}" debe ser INT para acceder a un array.')
                    self.node_type[ctx] = self.ERROR

    def exitVar_type(self, ctx: DecafParser.Var_typeContext):
        self.node_type[ctx] = self.VOID

    def exitField_var(self, ctx: DecafParser.Field_varContext):
        if ctx not in self.node_type.keys():
            if ctx.var_id() is not None:
                self.node_type[ctx] = self.node_type[ctx.getChild(0)]
            elif ctx.array_id() is not None:
                self.node_type[ctx] = self.node_type[ctx.getChild(0)]

    def enterField_declr(self, ctx: DecafParser.Field_declrContext):
        tipo = ctx.var_type().getText()

        for child in ctx.children:
            if not isinstance(child, TerminalNode) and isinstance(child, DecafParser.Field_varContext):
                id = child.var_id().getText()

                if self.current_scope.LookUp(id) == 0:
                    type_symbol = self.tabla_tipos.LookUp(tipo)
                    size = type_symbol['Size']
                    offset = self.current_scope._offset
                    
                    self.current_scope.Add(tipo, id, size, offset, False)
                else:
                    self.node_type[child] = self.ERROR
                    line = child.var_id().start.line
                    col = child.var_id().start.column
                    self.errores.Add(line, col, self.errores.IDENTIFICADOR_DECLARADO_MUCHAS_VECES)

    def exitField_declr(self, ctx: DecafParser.Field_declrContext):
        self.node_type[ctx] = self.VOID
        for child in ctx.children:
            if not isinstance(child, TerminalNode):
                if self.node_type[child] == self.ERROR:
                    self.node_type[ctx] = self.ERROR
                    break

    def exitVardeclr(self, ctx: DecafParser.VardeclrContext):
        # if ctx.field_var().var_id() is not None:
        self.node_type[ctx] = self.VOID
        for child in ctx.children:
            if not isinstance(child, TerminalNode):
                if self.node_type[child] == self.ERROR:
                    self.node_type[ctx] = self.ERROR
                    break
        # elif ctx.field_var().array_id() is not None:
        #     print('DECLARACION DE UN ARRAY')

    def exitString_literal(self, ctx: DecafParser.String_literalContext):
        self.node_type[ctx] = self.STRING

    def exitInt_literal(self, ctx: DecafParser.Int_literalContext):
        self.node_type[ctx] = self.INT

    def exitBool_literal(self, ctx: DecafParser.Bool_literalContext):
        self.node_type[ctx] = self.BOOLEAN

    def exitLiteral(self, ctx: DecafParser.LiteralContext):
        self.node_type[ctx] = self.node_type[ctx.getChild(0)]

    def enterBlock(self, ctx: DecafParser.BlockContext):
        parent = ctx.parentCtx
        
        if not isinstance(parent, DecafParser.Method_declrContext):
            self.NewScope()

    def exitBlock(self, ctx: DecafParser.BlockContext):
        parent = ctx.parentCtx
        
        if not isinstance(parent, DecafParser.Method_declrContext):
            self.PopScope()

        hijos_tipo = [self.node_type[i] for i in ctx.children if isinstance(i, DecafParser.StatementContext)]
        filtered = list(filter(lambda tipo: tipo != self.VOID, hijos_tipo))
        if len(filtered) == 0:
            self.node_type[ctx] = self.VOID
            return

        if len(filtered) == 1:
            self.node_type[ctx] = filtered.pop()
            return

        if self.all_equal(filtered):
            self.node_type[ctx] = filtered.pop()
        else:
            self.node_type[ctx] = self.ERROR

    def exitMethod_call(self, ctx: DecafParser.Method_callContext):
        name = ctx.method_name().getText()
        parameters = []

        for child in ctx.children:
            if isinstance(child, DecafParser.ExprContext):
                parameters.append(child)

        method_info = self.tabla_methods.LookUp(name)
        if method_info == 0:
            self.node_type[ctx] = self.ERROR
            line = ctx.method_name().start.line
            col = ctx.method_name().start.column
            self.errores.Add(line, col, f'El método "{name}" no existe o no hay definición del método previamente a ser invocado.')
            return

        if len(parameters) != len(method_info['Parameters']):
            self.node_type[ctx] = self.ERROR
            line = ctx.method_name().start.line
            col = ctx.method_name().start.column
            self.errores.Add(line, col, self.errores.NUMERO_PARAMETROS_METODO)
            return

        if len(parameters) == 0:
            self.node_type[ctx] = method_info['Tipo']
            return

        hasError = False
        for i in range(len(parameters)):
            tipo_parametro = self.node_type[parameters[i]]
            tipo_metodo = method_info['Parameters'][i]['Tipo']

            if tipo_parametro != tipo_metodo:
                hasError = True

                line = parameters[i].start.line
                col = parameters[i].start.column
                self.errores.Add(line, col, self.errores.TIPO_PARAMETROS_METODO)

            if hasError:
                self.node_type[ctx] = self.ERROR
            else:
                self.node_type[ctx] = method_info['Tipo']

    def exitStatement_if(self, ctx: DecafParser.Statement_ifContext):
        error = self.ChildrenHasError(ctx)
        if error:
            self.node_type[ctx] = self.ERROR
            return

        tipo_if = self.node_type[ctx.expr()]
        
        if tipo_if != self.BOOLEAN:
            self.node_type[ctx] = self.ERROR
            line = ctx.expr().start.line
            col = ctx.expr().start.column
            self.errores.Add(line, col, self.errores.IF_BOOLEAN)
            return

        hijos_tipo = [self.node_type[i] for i in ctx.children if isinstance(i, DecafParser.BlockContext)]
        if len(hijos_tipo) == 1:
            self.node_type[ctx] = hijos_tipo.pop()
        else:
            if hijos_tipo[0] == hijos_tipo[1]:
                self.node_type[ctx] = hijos_tipo.pop()
            else:
                self.node_type[ctx] = self.ERROR
        
    def exitStatement_while(self, ctx: DecafParser.Statement_whileContext):
        error = self.ChildrenHasError(ctx)
        if error:
            self.node_type[ctx] = self.ERROR
            return

        tipo_while = self.node_type[ctx.expr()]
        
        if tipo_while != self.BOOLEAN:
            self.node_type[ctx] = self.ERROR
            line = ctx.expr().start.line
            col = ctx.expr().start.column
            self.errores.Add(line, col, self.errores.WHILE_BOOLEAN)
            return

        hijos_tipo = [self.node_type[i] for i in ctx.children if isinstance(i, DecafParser.BlockContext)]
        if len(hijos_tipo) == 1:
            self.node_type[ctx] = hijos_tipo.pop()

    def exitStatement_return(self, ctx: DecafParser.Statement_returnContext):
        error = self.ChildrenHasError(ctx)
        if error:
            self.node_type[ctx] = self.ERROR
            return

        self.node_type[ctx] = self.node_type[ctx.expr()]

    def exitStatement_methodcall(self, ctx: DecafParser.Statement_methodcallContext):
        error = self.ChildrenHasError(ctx)
        if error:
            self.node_type[ctx] = self.ERROR
            return

        self.node_type[ctx] = self.node_type[ctx.method_call()]

    def exitStatement_break(self, ctx: DecafParser.Statement_breakContext):
        error = self.ChildrenHasError(ctx)
        if error:
            self.node_type[ctx] = self.ERROR
            return

        self.node_type[ctx] = self.VOID

    def exitStatement_assign(self, ctx: DecafParser.Statement_assignContext):
        error = self.ChildrenHasError(ctx)
        if error:
            self.node_type[ctx] = self.ERROR
            return

        left = self.node_type[ctx.location()]
        right = self.node_type[ctx.expr()]
        result_type = self.VOID

        if left != right:
            result_type = self.ERROR
            line = ctx.assign_op().start.line
            col = ctx.assign_op().start.column
            self.errores.Add(line, col, self.errores.ASIGNACION)
        self.node_type[ctx] = result_type

    def exitExpr(self, ctx: DecafParser.ExprContext):
        nodes_nonterminals = []
        for child in ctx.children:
            if not isinstance(child, TerminalNode):
                nodes_nonterminals.append(child)

        if len(nodes_nonterminals) == 1:
            non_terminal = nodes_nonterminals.pop()
            
            self.node_type[ctx] = self.node_type[non_terminal]
        # elif len(nodes_nonterminals) == 0:
        #     self.node_type[ctx] = self.VOID
        else:
            tipo1 = self.node_type[ctx.getChild(0)]
            tipo2 = self.node_type[ctx.getChild(2)]

            result_type = self.ERROR
            error = ''
            hasError = False

            if ctx.eq_op() is not None:
                if len(self.Intersection([tipo1, tipo2], [self.STRING, self.INT, self.BOOLEAN])) > 0 and tipo1 == tipo2:
                    result_type = self.BOOLEAN
                else:
                    hasError = True
                    line = ctx.getChild(0).start.line
                    col = ctx.getChild(0).start.column
                    error = self.errores.EQ_OPS
            elif ctx.arith_op() is not None or ctx.rel_op() is not None:
                if tipo1 == self.INT and tipo2 == self.INT:
                    result_type = self.INT
                    if ctx.rel_op() is not None:
                        result_type = self.BOOLEAN
                else:
                    hasError = True
                    if tipo1 != self.INT:
                        line = ctx.getChild(0).start.line
                        col = ctx.getChild(0).start.column
                    else:
                        line = ctx.getChild(2).start.line
                        col = ctx.getChild(2).start.column

                    if ctx.arith_op() is not None:
                        error = self.errores.ARITH_OP
                    else:
                        error = self.errores.REL_OP
            elif ctx.cond_op() is not None:
                if tipo1 == self.BOOLEAN and tipo2 == self.BOOLEAN:
                    result_type = self.BOOLEAN
                else:
                    hasError = True
                    if tipo1 != self.BOOLEAN:
                        line = ctx.getChild(0).start.line
                        col = ctx.getChild(0).start.column
                    else:
                        line = ctx.getChild(2).start.line
                        col = ctx.getChild(2).start.column

                    error = self.errores.COND_OP
            else:
                result_type = self.VOID

            if hasError:
                self.errores.Add(line, col, error)
            self.node_type[ctx] = result_type

    def IterateChildren(self, location, parent_type, description):
        
        if location.var_id() is not None:
            # CASO BASE
            if location.var_id().location() is None:
                tipo_retorno = self.ERROR
                id = location.var_id().getChild(0).getText()
                # print(id, parent_type, description)
                if 'struct' in description:
                    child = self.tabla_struct.GetChild(parent_type, id)
                    if child == 0:
                        self.node_type[location] = self.ERROR
                        line = location.start.line
                        col = location.start.column
                        self.errores.Add(line, col, f'Variable "{id}" no ha sido declarada previamente.')
                    else:
                        tipo_nodo = self.tabla_tipos.LookUp(child['Tipo'])
                        # print(tipo_nodo)
                        tipo_retorno = tipo_nodo['Tipo']
                        self.node_type[location] = tipo_nodo['Tipo']
                else:
                    line = location.start.line
                    col = location.start.column
                    self.errores.Add(line, col, self.errores.MUST_STRUCT)

                return tipo_retorno
            
            print('----------------------------------------------------------------------------------------')
            id = location.var_id().getChild(0).getText()
            # print(id)
            tipo_nodo = None
            child_type = None
            child_desc = None

            if 'struct' in description:
                child = self.tabla_struct.GetChild(parent_type, id)
                if child == 0:
                    line = location.start.line
                    col = location.start.column
                    self.errores.Add(line, col, f'Variable "{id}" no ha sido declarada previamente.')
                else:
                    child_type = child['Tipo']
                    child_desc = child['Description']
                    tipo_nodo = self.tabla_tipos.LookUp(child['Tipo'])
                    print('****************************', id, child, tipo_nodo)
            else:
                line = location.start.line
                col = location.start.column
                self.errores.Add(line, col, self.errores.MUST_STRUCT)

            result_type = self.IterateChildren(location.var_id().location(), child_type, child_desc)
            self.node_type[location] = result_type
            return result_type

        elif location.array_id() is not None:
            # CASO BASE
            
            if location.array_id().location() is None:
                tipo_retorno = self.ERROR
                id = location.array_id().getChild(0).getText()
                if 'struct' in description:
                    child = self.tabla_struct.GetChild(parent_type, id)
                    print('--', id, parent_type, child, '--')
                    if child == 0:
                        self.node_type[location] = self.ERROR
                        line = location.start.line
                        col = location.start.column
                        self.errores.Add(line, col, f'Variable "{id}" no ha sido declarada previamente.')
                    else:
                        tipo_nodo = self.tabla_tipos.LookUp(child['Tipo'])
                        # print(tipo_nodo)
                        tipo_retorno = tipo_nodo['Tipo'].split('array')[-1]
                        self.node_type[location] = tipo_nodo['Tipo'].split('array')[-1]
                else:
                    line = location.start.line
                    col = location.start.column
                    self.errores.Add(line, col, self.errores.MUST_STRUCT)

                return tipo_retorno
            
            print('----------------------------------------------------------------------------------------')
            id = location.array_id().getChild(0).getText()
            # print(id)
            tipo_nodo = None
            child_type = None
            child_desc = None

            if 'struct' in description:
                child = self.tabla_struct.GetChild(parent_type, id)
                print('ITERATE CHILDREN 2', child)
                if child == 0:
                    line = location.start.line
                    col = location.start.column
                    self.errores.Add(line, col, f'Variable "{id}" no ha sido declarada previamente.')
                else:
                    child_type = child['Tipo']
                    child_desc = child['Description']
                    tipo_nodo = self.tabla_tipos.LookUp(child['Tipo'])
            else:
                line = location.start.line
                col = location.start.column
                self.errores.Add(line, col, self.errores.MUST_STRUCT)

            print('****************************', id, child, tipo_nodo)
            result_type = self.IterateChildren(location.array_id().location(), child_type, child_desc)
            self.node_type[location] = result_type
            return result_type

    def enterLocation(self, ctx: DecafParser.LocationContext):
        if ctx in self.node_type.keys():
            return
        if ctx.var_id() is not None:
            if ctx.var_id().location() is None:
                return
        elif ctx.array_id() is not None:
            if ctx.array_id().location() is None:
                return
        
        if ctx.var_id() is not None:
            if ctx.var_id().location() is not None:
                print('------------ LOCATION ENTRADA -------------------')
                id = ctx.var_id().getChild(0).getText()
                print(id)
                symbol = self.Find(id)
                print(symbol)
                tipo_id = self.tabla_tipos.LookUp(symbol['Tipo'])
                print(tipo_id)
                # children = self.tabla_struct.GetChild(symbol['Tipo'], id)
                # print(children)
                result_type = self.IterateChildren(ctx.var_id().location(), tipo_id['Tipo'], tipo_id['Description'])
                self.node_type[ctx] = result_type
                print('------------ LOCATION SALIDA -------------------', result_type)

        if ctx.array_id() is not None:
            if ctx.array_id().location() is not None:
                print('------------ LOCATION ENTRADA -------------------')
                id = ctx.array_id().getChild(0).getText()
                print(id)
                symbol = self.Find(id)
                print(symbol)
                tipo_id = self.tabla_tipos.LookUp(symbol['Tipo'])
                print(tipo_id)
                print('ITERATE CHILDREN location')
                # children = self.tabla_struct.GetChild(symbol['Tipo'], id)
                # print(children)
                result_type = self.IterateChildren(ctx.array_id().location(), tipo_id['Tipo'], tipo_id['Description'])
                self.node_type[ctx] = result_type
                print('------------ LOCATION SALIDA -------------------', result_type)

    def exitLocation(self, ctx: DecafParser.LocationContext):
        if ctx not in self.node_type.keys():
            self.node_type[ctx] = self.node_type[ctx.getChild(0)]

    def exitDeclaration(self, ctx: DecafParser.DeclarationContext):
        self.node_type[ctx] = self.node_type[ctx.getChild(0)]

    def exitProgram(self, ctx: DecafParser.ProgramContext):
        main_method = self.tabla_methods.LookUp('main')
        if main_method != 0:
            if len(main_method['Parameters']) > 0:
                self.node_type[ctx] = self.ERROR
                self.errores.Add(0, 0, self.errores.MAIN_PARAMETERLESS)   
            else:
                hasError = self.ChildrenHasError(ctx)
                if hasError:
                    self.node_type[ctx] = self.ERROR
                else:
                    self.node_type[ctx] = self.VOID
        else:
            self.node_type[ctx] = self.ERROR
            self.errores.Add(0, 0, self.errores.MAIN_PARAMETERLESS)


        self.current_scope.ToTable()
        print('---------- FIN --------------')


        self.tabla_methods.ToTable()
        # for i, j in self.node_type.items():
        #     if isinstance(i, DecafParser.Method_declrContext):
        #         print(i, j)

        # print(self.node_type)
        self.tabla_struct.ToTable()

        if self.node_type[ctx] == self.ERROR:
            self.errores.ToString()
        # else:
        #     print('NO HAY ERRORES. TODO BIEN TODO CORRECTO.')


class Compilar():
    def __init__(self, url):
        self.printer = None

        input = FileStream(url)
        lexer = DecafLexer(input)
        stream = CommonTokenStream(lexer)
        parser = DecafParser(stream)
        tree = parser.program()

        self.printer = DecafPrinter()
        walker = ParseTreeWalker()
        walker.walk(self.printer, tree)

# def main():
#     if len(sys.argv) >= 2:
#         print('INPUT')
#         print(input)
#         lexer = DecafLexer(input)
#         stream = CommonTokenStream(lexer)
#         parser = DecafParser(stream)
#         tree = parser.program()

#         printer = DecafPrinter()
#         walker = ParseTreeWalker()
#         walker.walk(printer, tree)
#         # print('ROOT', printer.node_type[printer.root])
#         # print(printer.errores.GetErrores())
#     else:
#         print('No se ingresó un archivo como parámetro.')
#         print('Ej. python proyecto2.py suma.decaf')

# a = Compilar('fact_array.decaf')
# main()
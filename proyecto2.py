from prettytable.prettytable import NONE
from antlr4 import *
from antlr4.tree.Trees import TerminalNode
from DecafLexer import DecafLexer
from DecafListener import DecafListener
from DecafParser import DecafParser

from utilities import *

import sys

class DecafPrinter(DecafListener):
    def __init__(self) -> None:
        self.STRING = 'string'
        self.INT = 'int'
        self.BOOLEAN = 'boolean'
        self.VOID = 'void'
        self.ERROR = 'error'

        self.data_type = {
            'string': self.STRING,
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
            for scope in self.ambitos:
                lookup2 = scope.LookUp(var)
                if lookup2 != 0:
                    return lookup2
            return 0
        else:
            return lookup

    def Intersection(self, a, b):
        return [v for v in a if v in b]

    def enterProgram(self, ctx: DecafParser.ProgramContext):
        print('---------- INICIO --------------')
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
        self.PopScope()

    def enterVardeclr(self, ctx: DecafParser.VardeclrContext):
        tipo = ctx.var_type().getText()

        # TOMAR EN CUENTA DECLARACION DE ARRAY'S
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
        

    def enterStruct_declr(self, cstx: DecafParser.Struct_declrContext):
        self.NewScope()

    def exitStruct_declr(self, ctx: DecafParser.Struct_declrContext):
        tipo = ctx.getChild(0).getText() + ctx.getChild(1).getText()

        if self.tabla_tipos.LookUp(tipo) == 0:
            size_scope = self.current_scope.GetSize()
            self.tabla_tipos.Add(tipo, size_scope)
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

    def exitVar_type(self, ctx: DecafParser.Var_typeContext):
        self.node_type[ctx] = self.VOID

    def exitField_var(self, ctx: DecafParser.Field_varContext):
        if ctx not in self.node_type.keys():
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
        self.node_type[ctx] = self.VOID
        for child in ctx.children:
            if not isinstance(child, TerminalNode):
                if self.node_type[child] == self.ERROR:
                    self.node_type[ctx] = self.ERROR
                    break

    def exitString_literal(self, ctx: DecafParser.String_literalContext):
        self.node_type[ctx] = self.STRING

    def exitInt_literal(self, ctx: DecafParser.Int_literalContext):
        self.node_type[ctx] = self.INT

    def exitBool_literal(self, ctx: DecafParser.Bool_literalContext):
        self.node_type[ctx] = self.BOOLEAN

    def exitLiteral(self, ctx: DecafParser.LiteralContext):
        self.node_type[ctx] = self.node_type[ctx.getChild(0)]

    def exitMethod_call(self, ctx: DecafParser.Method_callContext):
        name = ctx.method_name().getText()
        parameters = []

        for child in ctx.children:
            if isinstance(child, DecafParser.ExprContext):
                parameters.append(child)

        print('METHOD CALL', name, len(parameters))
        method_info = self.tabla_methods.LookUp(name)

        if len(parameters) != len(method_info['Parameters']):
            self.node_type[ctx] = self.ERROR
            line = ctx.method_name().start.line
            col = ctx.method_name().start.column
            self.errores.Add(line, col, self.errores.NUMERO_PARAMETROS_METODO)
            pass

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



    def exitExpr(self, ctx: DecafParser.ExprContext):
        nodes_nonterminals = []
        for child in ctx.children:
            if not isinstance(child, TerminalNode):
                nodes_nonterminals.append(child)

        if len(nodes_nonterminals) == 1:
            non_terminal = nodes_nonterminals.pop()
            
            self.node_type[ctx] = self.node_type[non_terminal]
            
        # TODO: IMPLEMENTAR LOGICA DE OPERACIONES
        else:
            tipo1 = self.node_type[ctx.getChild(0)]
            tipo2 = self.node_type[ctx.getChild(2)]

            result_type = ''
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
                else:
                    hasError = True
                    if tipo1 != self.INT:
                        line = ctx.getChild(0).start.line
                        col = ctx.getChild(0).start.column
                    else:
                        line = ctx.getChild(2).start.line
                        col = ctx.getChild(2).start.column

                    if ctx.arith_op() is not None:
                        error = self.errores.EQ_OPS
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

            if hasError:
                self.errores.Add(line, col, error)
            self.node_type[ctx] = result_type


    def exitLocation(self, ctx: DecafParser.LocationContext):
        self.node_type[ctx] = self.node_type[ctx.getChild(0)]

    def exitProgram(self, ctx: DecafParser.ProgramContext):
        self.current_scope.ToTable()
        print('---------- FIN --------------')

        main_method = self.tabla_methods.LookUp('main')
        if main_method != 0:
            if len(main_method['Parameters']) > 0:
                self.errores.Add(0, 0, self.errores.MAIN_PARAMETERLESS)    
        else:
            self.errores.Add(0, 0, self.errores.MAIN_PARAMETERLESS)

        self.tabla_methods.ToTable()
        
        for i, j in self.node_type.items():
            if isinstance(i, DecafParser.ExprContext):
                print(i, j)

        self.errores.ToString()



def main():
    if len(sys.argv) >= 2:
        input = FileStream(sys.argv[1])
        lexer = DecafLexer(input)
        stream = CommonTokenStream(lexer)
        parser = DecafParser(stream)
        tree = parser.program()

        printer = DecafPrinter()
        walker = ParseTreeWalker()
        walker.walk(printer, tree)
    else:
        print('No se ingresó un archivo como parámetro.')
        print('Ej. python proyecto2.py suma.decaf')


main()
from antlr4 import *
from antlr4.tree.Trees import TerminalNode
from DecafLexer import DecafLexer
from DecafListener import DecafListener
from DecafParser import DecafParser

from utilities import *

import sys

class DecafPrinter(DecafListener):
    def __init__(self) -> None:
        self.ambitos = []
        self.current_scope = None
        self.tabla_tipos = TablaTipos()
        self.errores = SemanticError()
        self.tabla_methods = TablaMetodos()

        super().__init__()

    def PopScope(self):
        self.current_scope.ToTable()
        self.current_scope = self.ambitos.pop()        

    def NewScope(self):
        self.ambitos.append(self.current_scope)
        self.current_scope = TablaSimbolos()

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
                    typeParameter = ctx.getChild(i).getText()
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
            line = ctx.field_var().var_id().start.line
            col = ctx.field_var().var_id().start.column
            self.errores.Add(line, col, self.errores.IDENTIFICADOR_DECLARADO_MUCHAS_VECES)
        
    def enterField_declr(self, ctx: DecafParser.Field_declrContext):
        tipo = ctx.var_type().getText()
        hijos = ctx.getChildCount()

        for i in range(hijos):
            if not isinstance(ctx.getChild(i), TerminalNode) and isinstance(ctx.getChild(i), DecafParser.Field_varContext):
                id = ctx.getChild(i).var_id().getText()
                type_symbol = self.tabla_tipos.LookUp(tipo)
                size = type_symbol['Size']
                offset = self.current_scope._offset
                
                self.current_scope.Add(tipo, id, size, offset, False)

    def enterStruct_declr(self, cstx: DecafParser.Struct_declrContext):
        self.NewScope()

    def exitStruct_declr(self, ctx: DecafParser.Struct_declrContext):
        tipo = ctx.getChild(0).getText() + ctx.getChild(1).getText()

        if self.tabla_tipos.LookUp(tipo) == 0:
            size_scope = self.current_scope.GetSize()
            self.tabla_tipos.Add(tipo, size_scope)
            self.PopScope()
        else:
            line = ctx.start.line
            col = ctx.start.column
            self.errores.Add(line, col, self.errores.IDENTIFICADOR_DECLARADO_MUCHAS_VECES)

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
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

        super().__init__()

    def PopScope(self):
        self.current_scope.ToTable()
        self.current_scope = self.ambitos.pop()        

    def NewScope(self):
        self.ambitos.append(self.current_scope)
        self.current_scope = TablaSimbolos()

    def enterMethod_declr(self, ctx: DecafParser.Method_declrContext):
        print('Entrando a metodo', ctx.method_name().getText())
        self.NewScope()

    def exitMethod_declr(self, ctx: DecafParser.Method_declrContext):
        self.PopScope()

    def enterProgram(self, ctx: DecafParser.ProgramContext):
        print('---------- INICIO --------------')
        self.current_scope = TablaSimbolos()

    def enterVardeclr(self, ctx: DecafParser.VardeclrContext):
        tipo = ctx.var_type().getText()

        # TOMAR EN CUENTA DECLARACION DE ARRAY'S
        id = ctx.field_var().var_id().getText()

        # Si no encuentra una variable, la guarda en la tabla de simbolos
        # En caso contrario, ya está declarada, y eso es ERROR.
        if self.current_scope.LookUp(id) == 0:
            type_symbol = self.tabla_tipos.LookUp(tipo)
            print(tipo, type_symbol)
            size = type_symbol['Size']
            offset = self.current_scope._offset

            print(tipo, id, size, offset)

            self.current_scope.Add(tipo, id, size, offset)
        else:
            line = ctx.field_var().var_id().start.line
            col = ctx.field_var().var_id().start.column
            self.errores.Add(line, col, 'Variable no puede estar declarada más de una vez en el mismo ámbito.')
        
    def enterField_declr(self, ctx: DecafParser.Field_declrContext):
        tipo = ctx.var_type().getText()
        hijos = ctx.getChildCount()

        for i in range(hijos):
            if not isinstance(ctx.getChild(i), TerminalNode) and isinstance(ctx.getChild(i), DecafParser.Field_varContext):
                id = ctx.getChild(i).var_id().getText()
                type_symbol = self.tabla_tipos.LookUp(tipo)
                size = type_symbol['Size']
                offset = self.current_scope._offset
                print(tipo, id, size, offset)
                
                self.current_scope.Add(tipo, id, size, offset)

    def enterStruct_declr(self, ctx: DecafParser.Struct_declrContext):
        print('STRUCT DECLR')
        self.NewScope()

    def exitStruct_declr(self, ctx: DecafParser.Struct_declrContext):
        tipo = ctx.getChild(0).getText() + ctx.getChild(1).getText()
        size_scope = self.current_scope.GetSize()
        self.tabla_tipos.Add(tipo, size_scope)
        print('SALIR DE STRUCT DECLR', size_scope)
        self.PopScope()

    def exitProgram(self, ctx: DecafParser.ProgramContext):
        self.current_scope.ToTable()
        print('---------- FIN --------------')

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
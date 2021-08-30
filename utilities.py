from prettytable import PrettyTable

class TablaSimbolos():
    def __init__(self):
        self.pretty_table = PrettyTable()
        self._symbols = []
        self._offset = 0
        print(' -- INICIANDO NUEVO AMBITO --')

    def Add(self, tipo, id, size, offset, isParameter):
        self._symbols.append({
            'Tipo': tipo,
            'Id': id,
            'Size': size,
            'Offset': offset,
            'IsParameter': isParameter
        })
        self._offset += size

    def LookUp(self, variable):
        for symbol in self._symbols:
            if symbol['Id'] == variable:
                return symbol

        return 0

    def GetSize(self):
        return sum(symbol['Size'] for symbol in self._symbols)

    def ToTable(self):
        self.pretty_table.field_names = ['Tipo', 'ID', 'Size', 'Offset', 'IsParameter']
        for i in self._symbols:
            self.pretty_table.add_row(list(i.values()))

        print(' ** SIMBOLOS **')
        print(self.pretty_table)
        self.pretty_table.clear_rows()


class TablaMetodos():
    def __init__(self):
        self.pretty_table = PrettyTable()
        self._methods = []
        print(' -- INICIANDO NUEVO AMBITO --')

    def Add(self, tipo, id, parameters, returnVariable):
        self._methods.append({
            'Tipo': tipo,
            'Id': id,
            'Parameters': parameters,
            'Return': returnVariable
        })

    def LookUp(self, variable):
        for method in self._methods:
            if method['Id'] == variable:
                return method

        return 0

    def ToTable(self):
        self.pretty_table.field_names = ['Tipo', 'ID', 'Parameters', 'Return']
        for i in self._methods:
            self.pretty_table.add_row(list(i.values()))

        print(' ** METODOS **')
        print(self.pretty_table)
        self.pretty_table.clear_rows()



class TablaTipos():
    def __init__(self):
        self._types = []
        self.Add('int', 4)
        self.Add('string', 2)
        self.Add('boolean', 1)
        self.Add('void', 0)
        print(' -- INICIANDO TABLA TIPOS --')

    def Add(self, tipo, size):
        self._types.append({
            'Tipo': tipo,
            'Size': size,
        })

    def LookUp(self, tipo):
        for type in self._types:
            if type['Tipo'] == tipo:
                return type

        return 0

class SemanticError():
    def __init__(self):
        self.errores = []
        self.IDENTIFICADOR_DECLARADO_MUCHAS_VECES = 'Identificador no puede estar declarado más de una vez en el mismo ámbito.'
        self.MAIN_PARAMETERLESS = 'No existe un método llamado main sin parámetros.'
        self.NUMERO_PARAMETROS_METODO = 'El número de argumentos en la llamada al método no coincide.'
        self.TIPO_PARAMETROS_METODO = 'El tipo de dato en los argumentos en la llamada al método no coincide.'
        self.EQ_OPS = 'El tipo de dato de operandos no es el mismo para los operadores "==" y "!=".'
        self.ARITH_OP = 'El tipo de dato de operandos no es el mismo para los operadores "==" y "!=".'
        self.REL_OP = 'El tipo de dato de operandos no es el mismo para los operadores "==" y "!=".'
        self.COND_OP = 'El tipo de dato en operación condicional debe ser boolean.'
        self.IF_BOOLEAN = 'El tipo de dato dentro de condición de IF debe ser boolean.'
        self.ASIGNACION = 'La asignación de dos valores deben ser del mismo tipo.'
        self.RETURN_TYPE = 'El valor de retorno debe de ser del mismo tipo con que fue declarado el método.'

    def Add(self, line, col, msg):
        self.errores.append({
            'Line': line,
            'Col': col,
            'Msg': msg
        })

    def ToString(self):
        for error in self.errores:
            print(' => Line ' + str(error['Line']) + ':' + str(error['Col']) + ' ' + error['Msg'])
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
        symbols_copy = self._symbols.copy()
        symbols_copy.reverse()
        for symbol in symbols_copy:
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

class TablaParametros():
    def __init__(self):
        self.pretty_table = PrettyTable()
        self._symbols = []
        print(' -- INICIANDO NUEVO AMBITO --')

    def Add(self, tipo, id):
        self._symbols.append({
            'Tipo': tipo,
            'Id': id,
        })

    def LookUp(self, variable):
        symbols_copy = self._symbols.copy()
        symbols_copy.reverse()
        for symbol in symbols_copy:
            if symbol['Id'] == variable:
                return symbol
        return 0

    def ToTable(self):
        self.pretty_table.field_names = ['Tipo', 'ID']
        for i in self._symbols:
            self.pretty_table.add_row(list(i.values()))

        print(' ** PARAMETERS **')
        print(self.pretty_table)
        self.pretty_table.clear_rows()

    def Clear(self):
        self.ToTable()
        self._symbols = []

class TablaStruct():
    def __init__(self):
        self.pretty_table = PrettyTable()
        self._symbols = []

    def Add(self, parent, tipo, id, description):
        self._symbols.append({
            'Parent': parent,
            'Tipo': tipo,
            'Id': id,
            'Description': description
        })

    def LookUp(self, variable):
        symbols_copy = self._symbols.copy()
        symbols_copy.reverse()
        for symbol in symbols_copy:
            if symbol['Id'] == variable:
                return symbol
        return 0

    def ToTable(self):
        self.pretty_table.field_names = ['Parent', 'Tipo', 'ID', 'Description']
        for i in self._symbols:
            self.pretty_table.add_row(list(i.values()))

        print(' ** STRUCTS **')
        print(self.pretty_table)
        self.pretty_table.clear_rows()

    def ExtractInfo(self, parent, scope, tabla_tipo):
        for i in scope._symbols:
            tipo = tabla_tipo.LookUp(i['Tipo'])
            self.Add(parent, i['Tipo'], i['Id'], tipo['Description'])
    
    def GetChild(self, tipo, name):
        copy_symbols = self._symbols.copy()
        copy_symbols.reverse()
        for symbol in copy_symbols:
            if symbol['Parent'] in tipo and symbol['Id'] == name:
                return symbol

        return 0

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
        self.PRIMITIVE = 'primitive'
        self.ARRAY = 'array'
        self.STRUCT = 'struct'

        self._types = []
        self.Add('int', 4, self.PRIMITIVE)
        self.Add('char', 2, self.PRIMITIVE)
        self.Add('boolean', 1, self.PRIMITIVE)
        self.Add('void', 0, self.PRIMITIVE)
        print(' -- INICIANDO TABLA TIPOS --')

    def Add(self, tipo, size, description):
        self._types.append({
            'Tipo': tipo,
            'Size': size,
            'Description': description
        })

    def LookUp(self, tipo):
        types_copy = self._types.copy()
        types_copy.reverse()
        for type in types_copy:
            if type['Tipo'] == tipo:
                return type
        return 0

class SemanticError():
    def __init__(self):
        self.errores = []
        self.IDENTIFICADOR_DECLARADO_MUCHAS_VECES = 'Identificador no puede estar declarado m??s de una vez en el mismo ??mbito.'
        self.MAIN_PARAMETERLESS = 'No existe un m??todo llamado main sin par??metros.'
        self.NUMERO_PARAMETROS_METODO = 'El n??mero de argumentos en la llamada al m??todo no coincide.'
        self.TIPO_PARAMETROS_METODO = 'El tipo de dato en los argumentos en la llamada al m??todo no coincide.'
        self.EQ_OPS = 'El tipo de dato de operandos no es el mismo para los operadores "==" y "!=".'
        self.ARITH_OP = 'El tipo de dato de operando debe ser INT para operadores aritm??ticos.'
        self.REL_OP = 'El tipo de dato de operando debe ser INT para operadores de relaci??n.'
        self.COND_OP = 'El tipo de dato en operaci??n condicional debe ser boolean.'
        self.IF_BOOLEAN = 'El tipo de dato dentro de condici??n de IF debe ser boolean.'
        self.WHILE_BOOLEAN = 'El tipo de dato dentro de condici??n de WHILE debe ser boolean.'
        self.ASIGNACION = 'La asignaci??n de dos valores deben ser del mismo tipo.'
        self.RETURN_TYPE = 'El valor de retorno debe de ser del mismo tipo con que fue declarado el m??todo.'
        self.RETURN_VOID = 'Un m??todo declarado VOID no puede retornar ning??n valor.'
        self.MUST_STRUCT = 'El tipo de dato de la variable debe ser STRUCT.'
        self.METHOD_NOT_DECLARED = 'El m??todo no existe o no hay definici??n del m??todo previamente a ser invocado.'
        self.SHADOW_PARAMETER = 'No es posible declarar una variable con el nombre de un par??metro.'

    def Add(self, line, col, msg):
        self.errores.append({
            'Line': line,
            'Col': col,
            'Msg': msg
        })

    def ToString(self):
        for error in self.errores:
            print(' => Line ' + str(error['Line']) + ':' + str(error['Col']) + ' ' + error['Msg'])

    def GetErrores(self):
        errors = []
        for error in self.errores:
            errors.append(' => Line ' + str(error['Line']) + ':' + str(error['Col']) + ' ' + error['Msg'])
        return errors

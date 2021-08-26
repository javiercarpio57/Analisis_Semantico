from prettytable import PrettyTable

class TablaSimbolos():
    def __init__(self):
        self.pretty_table = PrettyTable()
        self._symbols = []
        self._offset = 0
        print(' -- INICIANDO NUEVO AMBITO --')

    def Add(self, tipo, id, size, offset):
        self._symbols.append({
            'Tipo': tipo,
            'Id': id,
            'Size': size,
            'Offset': offset
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
        self.pretty_table.field_names = ['Tipo', 'ID', 'Size', 'Offset']
        for i in self._symbols:
            self.pretty_table.add_row(list(i.values()))

        print(self.pretty_table)
        self.pretty_table.clear_rows()



class TablaTipos():
    def __init__(self):
        self._types = []
        self.Add('int', 4)
        self.Add('string', 2)
        self.Add('boolean', 1)
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

    def Add(self, line, col, msg):
        self.errores.append({
            'Line': line,
            'Col': col,
            'Msg': msg
        })

    def ToString(self):
        for error in self.errores:
            print(' => Line ' + str(error['Line']) + ':' + str(error['Col']) + ' ' + error['Msg'])
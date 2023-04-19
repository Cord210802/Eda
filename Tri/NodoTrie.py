class nodoTrie:
    finished = False
    llaves = {}

    def __init__(self):
        self.finished = False
        self.llaves = {}

class Trie:
    def __init__(self):
        self.raiz = nodoTrie()
        self.cont = 0

    def busca(self, cadena):
        actual = self.raiz
        encontre = True
        for simbolo in cadena:
            if simbolo in actual.llaves:
                actual = actual.llaves[simbolo]
            else:
                encontre = False
                break
        return actual.finished and encontre

    def inserte(self, cadena):
        actual = self.raiz
        for simbolo in cadena:
            if simbolo not in actual.llaves:
                actual.llaves[simbolo] = nodoTrie()
            actual = actual.llaves[simbolo]
        actual.finished = True
        if not actual.finished:
            self.cont +=1
            actual.finished = True

tri = Trie()
tri.inserte("Ho")
print(tri.raiz.llaves["H"].finished)
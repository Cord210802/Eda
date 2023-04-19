import java.util.Random;

public class SkipList <T extends Comparable<T>>{
    NodoSkip<T> cabeza, cola;
    int cont;
    int niveles;
    public SkipList(){
        cabeza = null;
        cola = null;
        cabeza.derecha = cola;
        cola.izquierda = cabeza;
    }

    public NodoSkip<T> busca(T elemento){
        NodoSkip<T> actual = cabeza;
        NodoSkip<T> sentinela = cabeza;

        while (actual != null){
            while (actual.derecha.dato != null && actual.derecha.dato.compareTo(elemento) <= 0){
                actual = actual.derecha;
            }
            sentinela = actual;
            actual = actual.abajo;
        }
        return sentinela;
    }

    public NodoSkip<T> elimina(T elemento){
        NodoSkip<T> borrado = busca(elemento);
        NodoSkip<T> sentinela = borrado;
        if(!borrado.dato.equals(elemento)){
            throw new RuntimeException();
        }
        else{
            cont--;
            NodoSkip<T> izq = borrado.izquierda;
            NodoSkip<T> der = borrado.derecha;
            izq.derecha = der;
            der.izquierda = izq;
            borrado.izquierda = null;
            borrado.derecha = null;
            while(borrado.arriba!= null){
                borrado = borrado.arriba;
                izq = borrado.izquierda;
                der = borrado.derecha;
                izq.derecha = der;
                der.izquierda = izq;
                borrado.izquierda = null;
                borrado.derecha = null;
                borrado = borrado.arriba;
            }
            revisaAltura();
            return borrado;
        }
    }

    private void revisaAltura() {
        if(this.niveles > Math.floor(Math.log(cont))){
            NodoSkip<T> aux = cabeza.abajo;
            while(aux != null){
                aux.arriba = null;
            }
            cola = cola.abajo;
            cabeza = cabeza.abajo;
        }
    }

    public void inserta(T elem){
        NodoSkip<T> aux = busca(elem);
        NodoSkip<T> insertado = new NodoSkip<>(elem);
        aux.ligaDerehca(insertado);
        cont++;
        Random ran = new Random();
        int randomNum = ran.nextInt(2) + 1;
        while(niveles < (Math.log10(cont)/Math.log10(2)) && randomNum == 1){
            while (aux.izquierda != null && aux.arriba == null){
                aux = aux.izquierda;
            }
            if(aux.equals(cabeza)){
                agregaLista();
            }
            aux = aux.arriba;
            NodoSkip<T> nuevo = new NodoSkip(elem);
            aux.ligaDerehca(nuevo);
            insertado.ligaVertical(nuevo);
            insertado = nuevo;
        }
    }

    private void agregaLista() {
        
    }
}

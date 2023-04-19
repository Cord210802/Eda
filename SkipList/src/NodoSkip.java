import java.util.Objects;

public class NodoSkip <T extends Comparable<T>>{
    T dato;
    NodoSkip<T> derecha, izquierda, arriba, abajo;

    public NodoSkip(T dato) {
        this.dato = dato;
        this.derecha = null;
        this.izquierda = null;
        this.arriba = null;
        this.abajo = null;
    }
    public NodoSkip(){
        this.dato = null;
        this.derecha = null;
        this.izquierda = null;
        this.arriba = null;
        this.abajo = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodoSkip<?> nodoSkip = (NodoSkip<?>) o;
        return dato.equals(nodoSkip.dato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dato);
    }

    public void ligaDerehca(NodoSkip<T> nodo){
        if(nodo == null){
            return;
        }
        nodo.izquierda = this;
        nodo.derecha = this.derecha;
        this.derecha = nodo;
        nodo.derecha.izquierda = nodo;

    }

    public void ligaVertical(NodoSkip<T> nuevo) {
        if(nuevo == null){
            return;
        }
        nuevo.abajo = this;
        nuevo.arriba = this.arriba;
        this.arriba.abajo = nuevo;
        this.arriba = nuevo;
    }
}

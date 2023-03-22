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
}

public class NodoHash <T extends Comparable<T>> {
    T elem;
    NodoHash<T> sig;

    public NodoHash(){
        elem = null;
        sig = null;
    }

    public NodoHash(T elem){
        this.elem = elem;
        sig = null;
    }
}

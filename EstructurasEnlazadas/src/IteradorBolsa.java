
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class IteradorBolsa<T> implements Iterator<T> {
    private Nodo<T> primero;

    public IteradorBolsa(Nodo<T> primero) {
        this.primero = primero;
    }
    
    public boolean hasNext(){
        return primero!=null;
    }
    
    public T next(){
        T dato;
        if(hasNext()){
            dato = primero.getDato();
            primero = primero.getSiguiente();
        }
        else{
            throw new NoSuchElementException();
        }
        return dato;
    }

}

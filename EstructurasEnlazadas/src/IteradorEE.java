
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
public class IteradorEE <T> implements Iterator<T>{
    private EE coleccion;
    private Nodo<T> actual;
    
    public IteradorEE(EE coleccion){
        this.coleccion = coleccion;
        this.actual = coleccion.getPrimerNodo();
    }
    
    public boolean hasNext(){
        return actual != null;
    }
    
    public T next(){
        T dato;
        
        if (this.hasNext()){
            dato = actual.getDato();
            actual = actual.getSiguiente();
        }
        else{
            throw new NoSuchElementException();
        }
        return dato;
    }
}

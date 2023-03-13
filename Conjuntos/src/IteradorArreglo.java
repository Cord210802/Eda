
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
public class IteradorArreglo <T> implements Iterator<T>{
    private T[] coleccion;
    private int total;
    private int actual;
    
    public IteradorArreglo(T[] colec, int total){
        this.coleccion = colec;
        this.total = total;
        this.actual = 0;
    }

    @Override
    public boolean hasNext() {
        return actual < total;
    }

    @Override
    public T next() {
        if (this.hasNext()){
            T dato = coleccion[actual];
            actual++;
            return dato;
        }
        throw new NoSuchElementException();
    }
}

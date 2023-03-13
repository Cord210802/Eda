
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class BolsaEnlazada<T> implements BolsaADT<T>{
    Nodo<T> primero;
    int cant;

    public BolsaEnlazada() {
        this.primero = null;
        this.cant = 0;
    }
    
    public void agrega(T dato){
        Nodo<T> actual = new Nodo(dato);
        
        if (this.isEmpty()){
            primero = actual;
        }
        else{
            Nodo<T> aux = primero.getSiguiente();
            primero.setSiguiente(actual);
            actual.setSiguiente(aux);
        }
        cant++;
    }
    
    public boolean contiene(T dato, int n){
        Nodo<T> actual = primero;
        
        return contiene(dato, n, 0, actual);
    }
    
    private boolean contiene(T dato, int n, int cont, Nodo<T> actual){
        if (n == cont){
            return true;
        }
        else{
            if (actual == null){
                return false;
            }
            else{
                if (dato.equals(actual.getDato())){
                    cont++;
                }
                actual = actual.getSiguiente();
                return contiene(dato, n, cont, actual);
            }
        }
    }
    
    public int getCantidad(){
        return cant;
    }
    
    public Iterator<T> iterator(){
        return new IteradorBolsa(primero);
    }
    
    public boolean isEmpty(){
        return primero == null;
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        Nodo<T> aux = primero;
        
        while(aux != null){
            cad.append(aux.getDato());
            cad.append(" ");
            aux = aux.getSiguiente();
        }
        return cad.toString();
    }
    
    private T eliminaPrimero(){
        T dato;
        if (!isEmpty()){
            dato = primero.getDato();
            Nodo<T> aux = primero;
            primero = primero.getSiguiente();
            aux.setSiguiente(null);
            cant--;
        }
        else{
            throw new RuntimeException();
        }
        return dato;
    }
    
    public void quita(T dato){

        while(!isEmpty() && primero.getDato().equals(dato)){
            eliminaPrimero();
        }
        if (!isEmpty()){
            Nodo<T> actual = primero;
            Nodo<T> eliminado = actual.getSiguiente();
            
            while(eliminado != null){
                if (eliminado.getDato().equals(dato)){
                    Nodo<T> aux = eliminado;
                    actual.setSiguiente(eliminado.getSiguiente());
                    aux.setSiguiente(null);
                    cant--;
                }
                else{
                    actual = actual.getSiguiente();
                }
                eliminado = actual.getSiguiente();
            }
        }
    }
    
    public BolsaEnlazada<T> junta(BolsaADT <T> otra){
        BolsaEnlazada res = this;
        Iterator it = otra.iterator();
        
        res = junta(it, res);
        return res;
    }
    
    public BolsaEnlazada<T> junta(Iterator it, BolsaEnlazada<T> res){
        if (!it.hasNext()){
            return res;
        }
        else{
            res.agrega((T) it.next());
            return junta(it, res);
        }
    }
}

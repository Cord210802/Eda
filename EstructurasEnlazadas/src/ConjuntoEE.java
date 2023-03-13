
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class ConjuntoEE <T>{
    private EE <T> conjunto;
    
    public ConjuntoEE(){
        conjunto = new EE();
    }
    
    public boolean agrega (T dato){
        boolean res = false;
        if (!conjunto.buscaNodo(dato)){
            conjunto.agregaFinal(dato);
            res = true;
        }
        return res;
    }
    
    public T elimina (T dato){
        T eliminado = conjunto.eliminaElementoT(dato);
       
        return eliminado;
    }
    
    public boolean contiene(T dato){
        return conjunto.buscaNodo(dato);
    }
    
    public boolean estaVacio(){
        return conjunto.estaVacia();
    }
    
    public int getCardinalidad(){
        return conjunto.cuantosElementos();
    }
    
    public Iterator<T> iterator(){
        return new IteradorEE(conjunto);
    }
    
    public String toString(){
        return conjunto.toString();
    }
}

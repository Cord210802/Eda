/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class ColaEE <T>{
    private EE <T> cola;
    
    public ColaEE(){
        cola = new EE();
    }
    
    public void agrega(T dato){
        cola.agregaFinal(dato);
    }
    
    public T saca(){
        T dato = cola.quitarPrimero();
        
        return dato;
    }
    
    public boolean isEmpty(){
        return cola.estaVacia();
    }
    
    public T consultaPrimero(){
        return cola.getPrimero();
    }
    
    public int cuantosElementos(){
        return cola.cuantosElementos();
    }
    
    public T consultaUlitmo(){
        return cola.getUltimo();
    }
    
    public String toString(){
        return cola.toString();
    }
}

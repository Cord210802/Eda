/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class PilaEE <T>{
    private EE <T> pila;
    
    public PilaEE(){
        pila = new EE();
    }
    
    public void push(T dato){
        pila.agregaInicio(dato);
    }
    
    public T  pop(){
        T dato = pila.quitarPrimero();
        
        return dato;
    }
    
    public boolean isEmpty(){
        return pila.estaVacia();
    }
    
    public T peek(){
        return pila.getPrimero();
    }
    
    public boolean equals(Object obj){
        boolean res;
        
        if (obj == null){
            res = false;
        }
        else{
            if (!(obj instanceof PilaEE)){
                res = false;
            }
            else{
                res = pila.equals(((PilaEE)obj).pila);
            }
        }
        return res;
    }
    
    public String toString(){
        return pila.toString();
    }
}

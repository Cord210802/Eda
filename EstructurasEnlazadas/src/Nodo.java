/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class Nodo <T>{
    private T dato;
    private Nodo<T> siguiente;
    
    public Nodo(){
        this.siguiente = null;
    }
    
    public Nodo(T dato){
        this();
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    public boolean equals(Nodo<T> nod){
        return this.getDato()== nod.getDato();
    }
}

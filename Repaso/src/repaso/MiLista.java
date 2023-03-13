/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso;

/**
 *
 * @author jupac
 */
public class MiLista <T>{
  Nodo <T> cabeza; 
  int cont; 
  
  MiLista(){
    cabeza = new  Nodo<T>(); 
    cont=0; 
  }

  public void inserta(T elem){
      Nodo<T> temp=cabeza.getSiguiente(), nuevo= new  Nodo<T>(elem);
      nuevo.setSiguiente(temp);
      cabeza.setSiguiente(nuevo);
      cont++;

    }

  //To string para hacer tus pruebas
  public String toString(){
    String cad="";
    Nodo<T> actual = cabeza.getSiguiente();
    while(actual != null){
      cad+=actual.getDato().toString()+" ";
      actual = actual.getSiguiente();
    }
    return cad.toString();
  }
  //Cuantos elementos hay recursivo
  private int cuantosHay(int cont, Nodo<T> actual){
      if (actual == null){
          return cont;
      }
      else{
          cont ++;
          actual = actual.getSiguiente();
          return cuantosHay(cont, actual);
      }
  }
  
  public int cuantosHay(){
      return cuantosHay(0, cabeza.getSiguiente());
  }
  //otra versión para contar elementos
  private int cuenta(Nodo<T> actual){
    if (actual==null)
      return 0;
    return cuenta(actual.getSiguiente())+1;
  }
  public int cuenta(){
    return cuenta(cabeza.getSiguiente());
  }
  
  private Nodo<T> invierteElem(Nodo<T> actual){
      if (actual == null){
          return cabeza.getSiguiente();
      }
      
    T dato = actual.getDato();
    Nodo<T> temp = invierteElem(actual.getSiguiente());
    temp.setDato(dato);
    return temp.getSiguiente();
      
  }
  
  public void invierteElem(){
      invierteElem(cabeza.getSiguiente());
  }
}

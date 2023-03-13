/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso;

/**
 *
 * @author jupac
 */
public class MiListaJp <T>{
  Nodo <T> cabeza; 
  int cont; 
  
  MiListaJp(){
    cabeza = null; 
    cont=0; 
  }
  //Caso si lo quieres hacer en orden
  public void inserta(T dato){
    //Caso donde es el primer nodo
    if (cabeza == null){
      Nodo<T> nuevo = new Nodo(dato);
      nuevo.setSiguiente(cabeza);
      cabeza = nuevo;
      cont++;
    }
    else{
      //Caso donde no es el primer nodo
      Nodo<T> nuevo = new Nodo(dato);
      Nodo<T> actual = cabeza;

      while(actual.getSiguiente() != null){
        actual = actual.getSiguiente();
      }
      actual.setSiguiente(nuevo);
    }
  }
  //Caso si quieres insertar en desorden (mas eficiente)
  public void insertaDes(T dato){
    if (cabeza == null){
      Nodo<T> nuevo = new Nodo(dato);
      nuevo.setSiguiente(cabeza);
      cabeza = nuevo;
      cont++;
    }
    else{
        Nodo<T> actual = cabeza;
        Nodo<T> nuevo = new Nodo<T>(dato);

        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo); 
    }
  }

  public String toString(){
    StringBuilder cad = new StringBuilder();
    Nodo<T> actual = cabeza;
    while(actual != null){
      cad.append(actual.getDato());
      actual = actual.getSiguiente();
    }
    return cad.toString();
  }
  
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
      return cuantosHay(0, cabeza);
  }
 
      public T invierteElementos(Nodo<T> actual){
        if (actual.getSiguiente() == null){
            cabeza.setDato(actual.getDato());
            return cabeza.getDato();
        }
        else{
            invierteElementos(actual.getSiguiente());
            System.out.println(invierteElementos(actual.getSiguiente()));
            T dato = actual.getDato();
            actual.getSiguiente().setDato(dato);
            return dato;
        }
    }
    
    public void invierteElementos(){
        invierteElementos(cabeza);
    }
  
  
  
  private Nodo<T> invierteListas(Nodo<T> actual){
      if (actual.getSiguiente() == null){
          cabeza = actual;
          return actual;
      }
      else{
          Nodo<T> aux = invierteListas(actual.getSiguiente());
          actual.getSiguiente().setSiguiente(actual);
          actual.setSiguiente(null);
          return aux;
      }
  }
  
  
  
  public void invierteListas(){
      invierteListas(cabeza);
  }
  
  public void imprime(){
        imprime(cabeza);
    }
    private void imprime(Nodo<T> actual){
        if(actual!=null){
            System.out.println(actual.getDato().toString());
           imprime(actual.getSiguiente());
        }
    }   
}

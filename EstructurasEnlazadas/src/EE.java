
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class EE <T> {
    private Nodo<T> origen;
    
    public EE(){
        origen = null; //indica que la ee este vacia
    }
    
    public boolean estaVacia(){
        return origen == null;
    }
    
    public void agregaInicio(T dato){
        Nodo<T> nuevo = new Nodo(dato);
        
        nuevo.setSiguiente(origen);
        origen = nuevo;
    }
    
    public void agregaFinal(T dato){
        if (this.estaVacia()){
            agregaInicio(dato);
        }
        else{
            Nodo<T> nuevo = new Nodo(dato);
            Nodo<T> actual = origen;
            while (actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }
    
    public String toString(){
        return toString(origen, new StringBuilder());
    }
    
    private String toString(Nodo<T> actual, StringBuilder sB){
        if (actual == null){
            return sB.toString();
        }
        else{
            sB.append(actual.getDato()).append(" ");
            return toString(actual.getSiguiente(), sB);
        }
    }
    
    public T quitarPrimero(){
        T resultado = null;
        
        if (!this.estaVacia()){
            resultado = origen.getDato();
            Nodo<T> temporal = origen;
            origen = origen.getSiguiente();
            temporal.setSiguiente(null);
        }
        else{
            throw new RuntimeException();
        }
        return resultado;
    }
    
    public T quitaUltimo(){
        T resultado = null;
        
        if (!this.estaVacia()){
            Nodo<T> anterior = null;
            Nodo<T> actual = origen;
            while (actual.getSiguiente() != null){
                anterior = actual;
                actual = actual.getSiguiente();
            }
            resultado = actual.getDato();
            if (anterior == null) {//Hay un solo nodo
                origen = null;//Indica que queda vacia
            }
            else{
                anterior.setSiguiente(null);//Indica que rompes la conexion
            }
        }
        else{
            throw new RuntimeException();
        }
        return resultado;
    }
    
    public boolean buscaNodo(T dato){
        boolean res = false;
        Nodo<T> actual = origen;
        
        while (!res && actual != null){
            if (actual.getDato().equals(dato)){
                res = true;
            }
            actual = actual.getSiguiente();
        }
        return res;
    }
    
    public boolean eliminaElemento(T dato){
        boolean res = false;
        
        if (!this.estaVacia()){
            if (origen.getDato().equals(dato)){
                quitarPrimero();
                res = true;
            }
            else{
                Nodo<T> actual = origen;
                Nodo<T> anterior = null;
                while(!res && actual != null){
                    if (dato == actual.getDato()){
                        Nodo<T> aux = actual;
                        anterior.setSiguiente(actual.getSiguiente());
                        aux.setSiguiente(null);
                        res = true;
                    }
                anterior = actual;
                actual = actual.getSiguiente();
                } 
            }
        }
        return res;
    }
    
    public T eliminaElementoT(T dato){
        boolean res = false;
        T eliminado = null;
        
        if (!this.estaVacia()){
            if (origen.getDato().equals(dato)){
                res = true;
                eliminado = quitarPrimero();
            }
            else{
                Nodo<T> actual = origen;
                Nodo<T> anterior = null;
                while(!res && actual != null){
                    if (dato == actual.getDato()){
                        Nodo<T> aux = actual;
                        eliminado = actual.getDato();
                        anterior.setSiguiente(actual.getSiguiente());
                        aux.setSiguiente(null);
                        res = true;
                    }
                anterior = actual;
                actual = actual.getSiguiente();
                } 
            }
        }
        return eliminado;
    }
    
    public boolean eliminaSiguienteDe(T dato){
        boolean res = false;
        
        if (!this.estaVacia()){
            Nodo<T> actualSig = origen.getSiguiente();
            Nodo<T> actual = origen;
            while(actualSig != null && !res){
                if (actual.getDato().equals(dato)){
                    actual.setSiguiente(actualSig.getSiguiente());
                    actualSig.setSiguiente(null);
                    res = true;
                }
                else{
                    actualSig = actualSig.getSiguiente();
                    actual = actual.getSiguiente();
                }
            }
        }
        return res;
    }
    
    public boolean eliminaAnterior(T dato){
        boolean res = false;
        
        if (!this.estaVacia() && !dato.equals(origen.getDato())){
            Nodo<T> medio = origen.getSiguiente();
            Nodo<T> delante = medio.getSiguiente();
            Nodo<T> ultimo = origen;
            if (medio.equals(dato)){
                res = true;
                quitarPrimero();
            }
            else{
                while (medio != null && !res){
                    if (medio.getDato().equals(dato)){
                        Nodo<T> aux = medio;
                        ultimo.setSiguiente(delante);
                        aux.setSiguiente(null);
                        res = true;
                    }
                    if (medio.getSiguiente() != null){
                        delante = delante.getSiguiente();
                    }
                    ultimo = ultimo.getSiguiente();
                    medio = medio.getSiguiente();
                }   
            }
        }
        return res;
    }
    
    public boolean eliminaAnteriorF(T dato){
        boolean res = false;
        
        if (!this.estaVacia() && !dato.equals(origen.getDato()) && origen.getSiguiente()!= null){
            if (origen.getSiguiente().getDato().equals(dato)){
                res = true;
                quitarPrimero();
            }
            else{
                Nodo<T> anteriorQuitar = origen;
                Nodo<T> quitar = origen.getSiguiente();
                Nodo<T> buscado = quitar.getSiguiente();
                
                while(buscado != null && !res){
                    if (buscado.getDato().equals(dato)){
                        anteriorQuitar.setSiguiente(buscado);
                        quitar.setSiguiente(null);
                        res = true;
                    }
                    else{
                        anteriorQuitar = anteriorQuitar.getSiguiente();
                        quitar = quitar.getSiguiente();
                        buscado = quitar.getSiguiente();
                    }
                }
            }
        }
        return res;
    }
    
    public boolean instertaAntesQue(T refer, T nuevo){
        boolean res = false;
        
        if (!this.estaVacia()){
            Nodo<T> actual = origen;
            Nodo<T> guardaEspaldas = null;
            while(actual.getSiguiente() != null && !actual.getDato().equals(refer)){
                guardaEspaldas = actual;
                actual = actual.getSiguiente();
            }
            if (actual.getDato().equals(refer)){
                Nodo<T> link = new Nodo(nuevo);
                if (guardaEspaldas == null){
                    origen = link;
                    origen.setSiguiente(actual);
                }
                else{
                    guardaEspaldas.setSiguiente(link);
                    link.setSiguiente(actual);
                }
                res = true;
            }
        }
        return res;
    }
    
    public int eliminaTodosRepetidosOrdenado(){
        int cont = 0;
        Nodo<T> anterior;
        Nodo<T> actual;
        
        if (!estaVacia()){
            anterior = origen;
            actual = anterior.getSiguiente();
            while(actual != null){
                if (actual.getDato().equals(anterior.getDato())){
                    anterior.setSiguiente(actual.getSiguiente());
                    actual.setSiguiente(null);
                    cont++;
                    actual = anterior.getSiguiente();
                }
                else{
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
            }
        }
        return cont;
    }
    
    public int eliminaTodosRepetidosDesordenado(){
        int cont = 0;
        if (!this.estaVacia() && origen.getSiguiente() != null){ 
            Nodo<T> actual = origen.getSiguiente();
            Nodo<T> guardaespaldas = origen;
            Nodo<T> temp;
            ArrayList<T> aux = new ArrayList();
            aux.add(guardaespaldas.getDato());
            T dato;
            while(actual != null){
                dato = actual.getDato();
                if (aux.contains(dato)){
                    temp = actual;
                    actual = actual.getSiguiente();
                    guardaespaldas.setSiguiente(actual);
                    temp.setSiguiente(null);
                    cont++;
                }
                else{
                    aux.add(dato);
                    guardaespaldas = actual;
                    actual = actual.getSiguiente();
                }
            }
        }
        return cont;
    }
    
    public void mezcla(EE objeto){
        if (objeto != null && !objeto.estaVacia()){
            if (this.estaVacia()){
               this.origen = objeto.origen; 
            }
            else{
                Nodo<T> actual = origen;
                Nodo<T> actualObjeto = objeto.origen;
                Nodo<T> siguiente = actual.getSiguiente();
                Nodo<T> siguienteObjeto = actualObjeto.getSiguiente();
                
                while (siguiente != null && actualObjeto!= null){
                    actual.setSiguiente(actualObjeto);
                    actualObjeto.setSiguiente(siguiente);
                    actual = siguiente;
                    siguiente = siguiente.getSiguiente();
                    actualObjeto = siguienteObjeto;
                    if (siguienteObjeto != null){
                        siguienteObjeto = siguienteObjeto.getSiguiente();
                    }
                }
                if (actualObjeto != null){
                    actual.setSiguiente(actualObjeto);
                }
            }
        }
    }
    
    public T getUltimo(){
        Nodo<T> actual;
        
        if (this.estaVacia()){
            throw new RuntimeException();
        }
        else{
            actual = origen;
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
        }
        return actual.getDato();
    }
    
    public boolean equals(Object obj){
        boolean res = true;
        
        if (obj == null){
            res = false;
        }
        else{
            if (!(obj instanceof EE)){
                res = false;
            }
            else{
                Nodo<T> actual = origen;
                Nodo<T> actualObj = ((EE)obj).origen;
                
                while(actual != null && res && actualObj != null){
                    if (!actual.equals(actualObj)){
                        res = false;
                    }
                    actual = actual.getSiguiente();
                    actualObj = actualObj.getSiguiente();
                }
                if (res && (actualObj != null || actual != null)){
                    res = false;
                }
            }
        }
        return res;
    }
    
    public T getPrimero(){
        T dato;
        
        if (this.estaVacia()){
            throw new RuntimeException();
        }
        else{
            dato = origen.getDato();
        }
        return dato;
    }
    
    public int cuantosElementos(){
        int res = 0;
        
        if (!this.estaVacia()){
            Nodo<T> actual = origen;
            while(actual != null){
                actual = actual.getSiguiente();
                res++;
            }
        }
        return res;
    }
    
    public Nodo<T> getPrimerNodo(){
        if (this.estaVacia()){
            throw new RuntimeException();
        }
        else{
            return origen;
        }
    }
    
    
}

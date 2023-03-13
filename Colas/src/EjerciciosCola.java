
import java.util.ArrayList;
import pila.PilaA;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class EjerciciosCola {

    public static void invierteCola(ColaADT cola){
        PilaA pil = new PilaA();
        
        while(!cola.estaVacia()){
            pil.push(cola.saca());
        }
        while(!pil.isEmpty()){
            cola.agrega(pil.pop());
        }
    }
    
    public static <T> void invierteColaR(ColaADT<T> cola){
        if (cola != null && !cola.estaVacia()){
            T dato = cola.saca();
            invierteColaR(cola);
            cola.agrega(dato);
        }
    }
    
    public static <T> void eliminaRepetidos(ColaADT<T> cola){
        ArrayList<T> arr = new ArrayList();
        int i = 1;
        int tope = 0;
        while(!cola.estaVacia()){
            arr.add(cola.saca());
        }
        if (arr.size()>=1){
            cola.agrega(arr.get(0));
        }
        while(i<arr.size()){
            if (!arr.get(i).equals(arr.get(tope))){
                tope = i;
                cola.agrega(arr.get(i));
            }
            i++;
        }
    }
    
    private static <T> void eliminaRepetidosR(ColaADT<T> cola, ArrayList<T> arr, int i){
        T dato;
        if (!cola.estaVacia()){
            dato = cola.saca();
            if (!dato.equals(arr.get(i))){
                arr.add(dato);
                i = arr.size() - 1;
            }
            eliminaRepetidosR(cola, arr, i);
        }
        else{
            for (int j = 0; j < arr.size(); j++){
                cola.agrega(arr.get(j));
            }
        }
    }
    
    public static <T> void eliminaRepetidosR(ColaADT<T> cola){
        ArrayList<T> arr = new ArrayList();
        
        if (!cola.estaVacia()){
            arr.add(cola.saca());
            eliminaRepetidosR(cola, arr, 0);
        }
    }
    public static void main(String[] args) {
        ColaA col = new ColaA();
        ColaA colRepetidos = new ColaA();
        ColaA prueba;
        col.agrega("Juan");
        col.agrega("Cesar");
        col.agrega("Cesaron");
        col.agrega("Pablo");
        col.saca();
        System.out.println(col);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class Pregunta2 {

    public static int sumaEnteros(Nodo primero){
        int res = 0;
        boolean bandera = false;
        Nodo aux = primero;
        
        while(aux != null){
            if (aux.getDato() instanceof Integer){
                bandera = true;
                res += (Integer)aux.getDato();
            }
            aux = aux.getSiguiente();
        }
        if (!bandera){
            System.out.println("No se encontraron enteros");
            throw new RuntimeException();
        }
        return res;
    }
    public static void main(String[] args) {
        Nodo primero = new Nodo();
        Nodo segundo = new Nodo();
        Nodo tercero = new Nodo();
        primero.setDato("Hola");
        segundo.setDato(3);
        tercero.setDato(4.7);
        primero.setSiguiente(segundo);
        segundo.setSiguiente(tercero);
        System.out.println(sumaEnteros(primero));
    }
    
}

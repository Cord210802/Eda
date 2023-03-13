/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class EjercicioAvion {
    
    private static int consultaMenor(ColaADT<Persona> cola){
        int fecha = -1;
        Persona primera;
        
        if (!cola.estaVacia()){
            fecha = cola.consultaPrimero().calcEdad();
            primera = cola.consultaPrimero();
            cola.agrega(cola.saca());
            while (!cola.consultaPrimero().equals(primera)){
                if (cola.consultaPrimero().calcEdad() < fecha){
                    fecha = cola.consultaPrimero().calcEdad();
                }
                cola.agrega(cola.saca());
            }
        }
        return fecha;
    }

    public static void colaAvion(ColaADT<Persona> cola){
        ColaA<Persona> colaAux = new ColaA<Persona>();
        int fecha = consultaMenor(cola);
        
        while (!cola.estaVacia()){
            if (cola.consultaPrimero().calcEdad() == fecha){
                colaAux.agrega(cola.saca());
                fecha = consultaMenor(cola);
            }
            else{
                cola.agrega(cola.saca());
            }
        }
        while(!colaAux.estaVacia()){
            cola.agrega(colaAux.saca());
        }
    }
    
    public static void main(String[] args) {
        System.out.println(5%3);
    }    
}

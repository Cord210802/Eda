/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila;

/**
 *
 * @author jupac
 */
public class PuebasEjercicio12 {
    public static void main(String[] args) {
        Ejercicio12 ej = new Ejercicio12("((2+3)*4)");
        Ejercicio12 ej2 = new Ejercicio12("((2+3)*4");
        
        System.out.println(ej.revisaCadena());
        System.out.println(ej2.revisaCadena());
    }
    
}

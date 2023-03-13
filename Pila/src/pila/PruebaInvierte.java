/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila;

/**
 *
 * @author jupac
 */
public class PruebaInvierte {
    public static void main(String[] args) {
        InvierteCadena in = new InvierteCadena("Que pedo");
        
        in.realizarInversion();
        System.out.println(in.getCadInvertida());
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class PruebaEE {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        EE <Integer> eeEnteros = new EE();
        EE<Integer> eeEnteros2 = new EE();
        
        eeEnteros.agregaInicio(1);
        eeEnteros2.agregaInicio(1);
        eeEnteros.agregaFinal(2);
        eeEnteros2.agregaFinal(2);
        eeEnteros2.agregaFinal(4);
        System.out.println(eeEnteros.equals(eeEnteros2));
    }
}

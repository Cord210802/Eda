/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class PruebasExamen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BolsaEnlazada b1 = new BolsaEnlazada();
        BolsaEnlazada b2 = new BolsaEnlazada();
        BolsaEnlazada b3;
        b1.agrega(3);
        b1.agrega(5);
        b1.agrega(3);
        b1.agrega(3);
        b2.agrega(7);
        b2.agrega(7);
        b2.agrega(7);
        System.out.println(b1.toString());
        System.out.println(b1.toString());
        b3 = b1.junta(b2);
        System.out.println(b3);
        b3.quita(7);
        System.out.println(b3);
    }
    
}

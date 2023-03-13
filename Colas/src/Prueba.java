/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaA col = new ColaA();
        col.agrega(1);
        col.agrega(2);
        col.agrega(3);
        col.agrega(0);
        col.saca();
        col.saca();
        col.saca();
        col.agrega(2);
        col.sacaUltimo();
        System.out.println(col);
        
    }
    
}

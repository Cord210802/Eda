/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso;

/**
 *
 * @author jupac
 */
public class Repaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MiLista lista = new MiLista();
       lista.inserta(4);
       lista.inserta(3);
       lista.inserta(2);
       lista.inserta(1);
       System.out.println(lista);
       lista.invierteElem();
       System.out.println(lista);
    }
    
}

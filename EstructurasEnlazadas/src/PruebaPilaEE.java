
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class PruebaPilaEE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConjuntoEE conj = new ConjuntoEE();
        
        conj.agrega(4);
        conj.agrega(5);
        Iterator it = conj.iterator();
        
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}

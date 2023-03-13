
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class PruebaConjuntos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConjuntoA<String> num = new ConjuntoA();
        ConjuntoA<String> num1 = new ConjuntoA();
        ConjuntoA<String> num2 = new ConjuntoA();
        ConjuntoA<String> num3 = new ConjuntoA();
        ConjuntoADT<String> union;
        ConjuntoADT<String> inter;
        ConjuntoADT<String> resta;
        Iterator<String> it;
        StringBuilder cad = new StringBuilder();
        StringBuilder cad1 = new StringBuilder();
        int cont = 0;
        
        num.agrega("Juan Cordero");
        num.agrega("Nueve");
        num.agrega("Diez");
        num1.agrega("Juan Cordero");
        num1.agrega("Cuatro");
        num1.agrega("Cinco");
        System.out.println(num.toString());
        System.out.println(num.elimina("Nueve"));
        System.out.println(num.contiene("Ocho"));
        System.out.println(num.estaVacio());
        System.out.println(num.getCardinalidad());
        //Recuerda que tienes que declarar el arreglo una vez que ya tiene los elementos
        it = num.iterator();
        while(it.hasNext()){
            cad.append(it.next().toString());
            cont++;
        }
        for (String s:num){
            cad1.append(s.toString()).append(" ");
        }
        System.out.println(cont);
        System.out.println(cad.toString());
        System.out.println(cad1.toString());
        
        union = num.union(num1);
        System.out.println(union.toString());
        inter = num.interseccion(num1);
        System.out.println("Hola");
        System.out.println(inter.toString());
//        System.out.println(num.toString());
//        System.out.println(num1.toString());
//        resta = num2.resta(num3);
//        System.out.println(resta.toString());
    }
}
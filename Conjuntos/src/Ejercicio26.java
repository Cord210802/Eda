
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class Ejercicio26 {

    public static void ejercicio(ConjuntoADT<String> frances, ConjuntoADT<String> ingles, ConjuntoADT<String> otro, String arch){
        File archivo = new File(arch);
        String dato;
        int pos;
        String nombre;
        String idioma;
        
        try(Scanner lec = new Scanner(archivo)){
            while(lec.hasNext()){
                dato = lec.nextLine();
                pos = dato.indexOf(",");
                idioma = dato.substring(0, pos);
                nombre = dato.substring(pos + 1);
                nombre = nombre.toUpperCase();
                switch(idioma){
                    case "frances":
                        frances.agrega(nombre);
                        break;
                    case "ingles":
                        ingles.agrega(nombre);
                        break;
                    default:
                        otro.agrega(nombre);
                }
            }
        }
        catch(FileNotFoundException fnfe){
            System.err.print("No se encontro el archivo" + fnfe);
            System.exit(-1);
        }
    }
    
    public static String hablanInglesYFrances(ConjuntoADT<String> frances, ConjuntoADT<String> ingles){
        StringBuilder cad = new StringBuilder();
        ConjuntoADT<String> inter = frances.interseccion(ingles);
        Iterator<String> it = inter.iterator();
        
        while(it.hasNext()){
            cad.append(it.next() + " ");
        }
        return cad.toString();
    }
    
    public static int hablanSoloIngles(ConjuntoADT<String> frances, ConjuntoADT<String> ingles, ConjuntoADT<String> otro){
        int res = 0;
        ConjuntoADT<String> otroYfrances = frances.union(otro);
        ConjuntoADT<String> restaDeUnion = ingles.resta(otroYfrances);
        
        res = restaDeUnion.getCardinalidad();
        return res;
    }
    
    public static String hablanTodos(ConjuntoADT<String> frances, ConjuntoADT<String> ingles, ConjuntoADT<String> otro){
        StringBuilder cad = new StringBuilder();
        ConjuntoADT<String> otroYfrances = frances.interseccion(otro);
        ConjuntoADT<String> inter = ingles.interseccion(otroYfrances);
        Iterator<String> it = inter.iterator();
        
        while(it.hasNext()){
            cad.append(it.next());
        }
        
        return cad.toString();
    }
    public static void main(String[] args) {
        String arch = "Alumnos.txt";
        ConjuntoADT<String> fra = new ConjuntoA<String>();
        ConjuntoADT<String> ing = new ConjuntoA<String>();
        ConjuntoADT<String> otr = new ConjuntoA<String>();
        
        ejercicio(fra, ing, otr, arch);
        System.out.println(ing.getCardinalidad());
        System.out.println(hablanInglesYFrances(fra, ing));
        System.out.println(hablanSoloIngles(fra, ing, otr));
        System.out.println(hablanTodos(fra, ing, otr));
    }
    
}

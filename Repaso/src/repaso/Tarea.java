/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jupac
 */
public class Tarea {

    public static Pelicula[] leerArchivo(String archivo, int n){
        Pelicula [] pelis = new Pelicula[n];
        File arch = new File(archivo);
        try(Scanner lec = new Scanner(arch)){
            for(int i = 0; i<n; i++){
                String original = lec.nextLine();
                
                String [] separa = original.split(",");
                Integer codigo = Integer.parseInt(separa[0]);
                String fecha = separa[1];
                String nombre = separa[2];
                Pelicula p = new Pelicula(codigo, fecha, nombre);
                pelis[i] = p;
//                System.out.println(pelis[i]);
//                System.out.println(original);

            }
            lec.close();
        }
        catch(FileNotFoundException fnfe){
            System.err.print("La regaste " + fnfe);
            System.exit(-1);
        }
        return pelis;
    }
    
    public static <T> String toString(T arr[], int n){
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i< n; i++){
            cad.append(arr[i]);
            cad.append("\n");
            
        }
        return cad.toString();
    }
    
    public static void main(String[] args) {
        Ordenadores ord = new Ordenadores();
        int n = 17000; //23,245,1300,4587,9540,12000
        Pelicula [] pelis = leerArchivo("movie_titles2.txt", n);
        //System.out.println(toString(pelis, n));
        ord.mergeSort(pelis, n);
        System.out.println(toString(pelis, n));
        //ord.odrdena(pelis, n);
        //ord.bubbleSort(pelis, n);
    }
}

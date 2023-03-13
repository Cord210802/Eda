/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso;

/**
 *
 * @author jupac
 */
public class PruebaOrdenamiento {
    
    public static <T> String toString(T arr[], int n){
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i< n; i++){
            cad.append(arr[i] + " ");
        }
        return cad.toString();
    }
    public static void main(String[] args) {
        Integer arr [] = {7,4,5,25,-2,3};
        String arr1 [] = {"hola", "amigo", "casa", "pies", "donde"};
        int n = 6;
        Ordenadores o = new Ordenadores();
        o.quickSort(arr, 6);
        System.out.println(toString(arr, n));
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila;

/**
 *
 * @author jupac
 */
public class ArregloGenerico {

    public static <T> int busquedaSecuencial(T [] arr, T dato, int n){
        if (n==0){
            return -1;
        }
        else{
            if (arr[n-1].equals(dato)){
                return n-1;
            }
            else{
                return busquedaSecuencial(arr, dato, n-1);
            }
        }
    }
    
    public static <T> String toStringRec(T [] arr, int n){
        if (n==0){
            return "";
        }
        else{
            return toStringRec(arr, n-1) + arr[n-1].toString();
        }
    }
    
    public static String fibonacci(int n){
        if (n==0){
            return "0";
        }
        else{
            if (n==1){
                return "1";
            }
            else{
                return (Integer.parseInt(fibonacci(n-1)) + Integer.parseInt(fibonacci(n-2))) + "";
            }
        }
    }
    
    public static <T> int buscaBinariaR(T[]arr, int n, T dato){
        return buscaBinariaR(arr, 0 ,dato, n-1);
    }
    
    private static <T> int buscaBinariaR(T[]arr, int izquierda, T dato, int derecha){
        int cen;
        
        if (izquierda > derecha){
            return -1 * (izquierda + 1);
        }
        else{
            cen = (izquierda+derecha)/2;
            if (arr[cen].equals(dato)){
                return cen;
            }
            else{
                if (((Comparable)arr[cen]).compareTo(dato)<0){
                    izquierda = cen + 1;
                }
                else{
                    derecha = cen - 1;
                }
                return buscaBinariaR(arr, izquierda, dato, derecha);
            }
        }
    }
    
    public static <T> int posMayor(T[] arr, int n){
        if (n>0){
            return posMayor(arr, n, n-1);
        }
        else{
            return -1;
        }
    }
    
    private static <T> int posMayor(T[] arr, int n, int mayor){
        if (n==0){
            return mayor;
        }
        else{
            if (((Comparable)arr[n-1]).compareTo((Comparable)arr[mayor])>0){
                mayor = n-1;
            }
            return posMayor(arr, n-1, mayor);
        }
    }
    
    private static <T> void recorre(T[] arr, int nelem, int pos){
        if (pos<nelem-1){
            arr[pos] = arr[pos+1]; 
            recorre(arr, nelem, pos+1);
        }
        else{
            arr[nelem-1] = null;
        }
    }
    
    public static <T> int eliminaR (T[] arr, int n, T dato, int total){
        if (n>0){
            if (arr[n-1].equals(dato)){
                recorre(arr, total, n-1);
                total--;
            }
            return eliminaR(arr, n-1, dato, total);
        }
        else{
            return total;
        }
    }
    
    public static void main(String[] args) {
        Integer [] arr = {1,2,3,3,1,5};
        Integer [] arr1 = new Integer[10];
        int n;
//        System.out.println(busquedaSecuencial(arr,"" , 4));
////        System.out.println(toStringRec(arr, 2));
//        System.out.println(fibonacci(10));
//        System.out.println(buscaBinariaR(arr, 5, 0));
        n = eliminaR(arr, 6, 1, 6);
        for (int i = 0; i<n;i++){
            System.out.println(arr[i]);
        }
    }
    
}

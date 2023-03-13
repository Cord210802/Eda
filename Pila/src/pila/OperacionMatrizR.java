/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jupac
 */
public class OperacionMatrizR {
    
    private static int sumaRenglon(int [] arr, int n, int res){
        int sum;
        if (n==0){
            return res;
        }
        else{
            sum = arr[n-1];
            res += sum;
            return sumaRenglon(arr, n-1, res);
        }
    }
    
    public static int sumaRenglones(int [][] arr, int m, int n, int res){
        int sum;
        if (m==0){
            return res;
        }
        else{
            sum = sumaRenglon(arr[m-1], n, 0);
            res+= sum;
            return sumaRenglones(arr, m-1, n, res);
        }
    }
    
    private static int sumaPalabras(Scanner arch,int cont){
        if (!arch.hasNext()){
            return cont;
        }
        else{
            arch.next();
            cont++;
            return sumaPalabras(arch, cont);
        }
    }
    
    public static int sumaPalabras(String arch){
        File f = new File(arch);
        try(Scanner lec = new Scanner(f)){
            return sumaPalabras(lec, 0);
        }
        catch(FileNotFoundException fnfe){
            return -1;
        }
    }
    
    public static int sumaDiagonalPrincipal(int [][] m, int n, int suma){
        if (n==0){
            return suma;
        }
        else{
            suma += m[n-1][n-1];
            return sumaDiagonalPrincipal(m, n-1,suma);
        }
    }
    
    public static int [][] multiplicacionMatrizR(int [] [] matriz, int r, int c , int [] [] matriz2, int r2, int c2){
        int [][] res;
        
        if (c!=r2 || r==0 || c==0|| r2==0||c2==0){
            throw new RuntimeException("No se puede multiplicar esta matriz");
        }
        else{
            res = new int [r][c2];
            colocaDato(matriz, r, c, matriz2, r2, c2, res);
            return res;
        }
    }
    
    private static int mMatrizSuma(int [] [] matriz, int r, int c , int [] [] matriz2, int r2, int c2, int suma){
        if (c==0){
            return suma;
        }
        else{
            suma+= matriz[r-1][c-1] * matriz2[r2-1][c2-1];
            return mMatrizSuma(matriz, r, c-1, matriz2, r2-1, c2, suma);
        }
    }
    
    private static void colocaDato(int [] [] matriz, int r, int c , int [] [] matriz2, int r2, int c2, int [] [] res){
        if (r>0){
            if (c2>0){
               res[r-1][c2-1] = mMatrizSuma(matriz, r,c,matriz2, r2,c2,0);
               colocaDato(matriz, r, c, matriz2, r2, c2-1, res);
            }
            colocaDato(matriz, r-1, c, matriz2, r2, c2, res);
        }
    }
    
    public static void tHanoi(int n, String ori, String aux, String des){
        if (n==1){
            System.out.println("Mover 1 disco de " + ori + " a " + des);
        }
        else{
            tHanoi(n-1,ori,des,aux);
            System.out.println("Mover 1 disco de " + ori + " a " + des);
            tHanoi(n-1,aux,ori,des);
        }
    }
    
    public static void main(String[] args) {
        File prueba = new File("Prueba.txt");
        int r = 3;
        int c = 2;
        int [][] matriz = {{1,2},
                           {3,4},
                           {5,6}};
        int [][] matriz2 = {{1,2,3},
                           {3,4,5}};
       try{
        int [][] res = multiplicacionMatrizR(matriz, r, c, matriz2, c, r);
        
        for (int i = 0; i<r; i++){
            for (int j = 0; j<r; j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println("");
        }
       }
       catch(Exception e){
           System.out.println("No se puede multiplicar esta matriz");
       }
        
//        System.out.println(sumaRenglones(matriz, 3, 3, 0));
//        
//        try(Scanner lec = new Scanner(prueba)){
//            System.out.println(sumaPalabras(lec, 0));
//        }
//        catch(FileNotFoundException fnfe){
//            System.out.println("no se encontro el archivo" + fnfe);
//        }
        System.out.println(sumaPalabras("EjemploCesarPaulins"));
        tHanoi(6, "ori", "aux", "des");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso;

/**
 *
 * @author jupac
 */
public class Caballo {

    public static String imprimeMatriz(int matriz [][], int r, int c){
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                cad.append(matriz[i][j] + " " + "   ");
            }
            cad.append("\n");
        }
        return cad.toString();
    }
    
    public static boolean revisa(int matriz[][], int arr [], int mov[], int n){
        boolean res = false;
        int i = arr[0];
        int j = arr[1];
        int iMov = mov[0];
        int jMov = mov[1];
        if (i + iMov>=0 && i + iMov<n && j + jMov>=0 && j + jMov<n && matriz[i+iMov][j+jMov] == 0){
            res = true;
        }
        return res;
    }
    public static boolean caballo(int matriz [][], int cont, int arr [], int n){
        int mov [][] = {{2,1},
                        {-2,1},
                        {2,-1},
                        {-2,-1},
                        {1,2},
                        {1,-2},
                        {-1,-2},
                        {-1,2}};
        if (cont==49){
            return true;
        }
        else{
            for (int i = 0; i < 8; i++){
                if (revisa(matriz, arr, mov[i], n)){
                    cont = cont + 1;
                    matriz[arr[0]][arr[1]] = cont;
                    int movi = mov[i][0];
                    int movj = mov[i][1];
                    arr[0] = arr[0] + movi;
                    arr[1] = arr[1] + movj;
                    if (caballo(matriz, cont, arr, n)){
                        return true;
                    }
                    else{
                       arr[0] = arr[0] - movi;
                       arr[1] = arr[1] - movj;
                       matriz[arr[0]][arr[1]] = 0;
                       cont = cont - 1;
                    }
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        int tablero [][] = new int [7][7];
        for (int i = 0; i<7; i++){
            for (int j = 0 ; j<7; j++){
                tablero[i][j]= 0;
            }
        }
        int arr[] = {0,0};
        int arr1[] = {4,1};
        int arr2[] = {2,-1};
        System.out.println(caballo(tablero, 0, arr, 7));
        System.out.println(imprimeMatriz(tablero, 7, 7));
        System.out.println(revisa(tablero, arr1, arr2, 7));
    }
    
}

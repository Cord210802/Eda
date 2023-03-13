/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso;

/**
 *
 * @author jupac
 */
public class Reinas {

    public static String imprimeMatriz(int matriz [][], int r, int c){
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                cad.append(matriz[i][j] + " ");
            }
            cad.append("\n");
        }
        return cad.toString();
    }
    
    public static boolean cuentaReinas(int mat[][]){
        boolean res= false;
        int cont = 0;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j<8; j++){
                if (mat[i][j]==1){
                    cont++;
                }
            }
        }
        if (cont == 8){
            res = true;
        }
        return res;
    }
    
    public static boolean revisaDiagonal(int tablero[][], int r, int c){
        boolean res = true;
        int i = r;
        int j = c;
        //vas del punto a la diagonal de abajo 
        while (i<8 && j<8){
            if (tablero[i][j] == 1){
                res = false;
            }
            i++;
            j++;
        }
        i = r;
        j = c;
        while(res && i>=0 && j >=0){
            if (tablero[i][j] == 1){
                res = false;
            }
            i--;
            j--;
        }
        i = r;
        j = c;
        while(res && i>=0 && j<8){
            if(tablero[i][j] == 1){
                res = false;
            }
            i--;
            j++;
        }
        i = r;
        j = c;
        while(res && i<8 && j>=0){
            if(tablero[i][j] == 1){
                res = false;
            }
            i++;
            j--;
        }
        return res;
    }
    
    public static boolean valido(int tablero[][],int r,int c){
        boolean res = true;
        
        int i = 0;
        int j = 0;
        //Checa el renglon
        while (res && i < 8){
            if (tablero[r][i] == 1){
                res = false;
            }
            i++;
        }
        //Checa la columna
        while (res && j < 8){
            if (tablero[j][c] == 1){
                res = false;
            }
            j++;
        }
        if (res){
            res = revisaDiagonal(tablero, r, c);
        }
        return res;
    }
    
    public static boolean insertaReina(int matriz[][]){
        if (cuentaReinas(matriz)){
            return true;
        }
        else{
            for (int i = 0; i<8; i++){
                for (int j = 0; j<8;j++){
                    if (valido(matriz, i, j)){
                        matriz[i][j] = 1;
                        if(insertaReina(matriz)){
                            return true;
                        }
                        else{
                            matriz[i][j]=0;
                        }
                    }
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        int tablero [][] = {{0,0,0,0,0,0,0,0}
                           ,{0,0,0,0,0,0,0,0}
                           ,{1,0,0,0,0,0,0,0}
                           ,{0,0,0,0,0,0,0,0}
                           ,{0,0,0,0,0,0,0,0}
                           ,{0,0,0,0,0,0,0,0}
                           ,{0,0,0,0,0,0,0,0}
                           ,{0,1,0,0,0,0,0,0}};
        System.out.println(imprimeMatriz(tablero, 8, 8));
        System.out.println(insertaReina(tablero));
        System.out.println(imprimeMatriz(tablero, 8, 8));
    }
}

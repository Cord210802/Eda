/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso;

/**
 *
 * @author jupac
 */
public class Sodoku {

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
    
    public static boolean revisaCuadrante(int matriz[][], int n, int r, int c){
        boolean res = true;
        //Primer cuadrante
        if (res && r<=3 && c<=3){
            for (int i = 0; i<3; i++){
                for (int j = 0; j<3;j++){
                    if (matriz[i][j]==n){
                        res = false;
                    }
                }
            }
        }
        //Segundo cuadrante 
        if (res && r<=3 && 3<c && c<=6){
            for (int i = 0; i<3; i++){
                for (int j = 3; j<6;j++){
                    if (matriz[i][j]==n){
                        res = false;
                    }
                }
            }
        }
        //Tercer cuadrante 
        if (res && r<=3 && 6<c && c<=9){
            for (int i = 0; i<3; i++){
                for (int j = 6; j<9;j++){
                    if (matriz[i][j]==n){
                        res = false;
                    }
                }
            }
        }
        //Cuarto cuadrante
        if (res && 3<r && r<=6 && c<=3){
            for (int i = 3; i<6; i++){
                for (int j = 0; j<3;j++){
                    if (matriz[i][j]==n){
                        res = false;
                    }
                }
            }
        }
        //Quinto cuadrante 
        if (res && 3<r && r<=6 && 3<c && c<=6){
            for (int i = 3; i<6; i++){
                for (int j = 3; j<6;j++){
                    if (matriz[i][j]==n){
                        res = false;
                    }
                }
            }
        }
        //Sexto cuadrante 
        if (res && 3<r && r<=6 && 6<c && c<=9){
            for (int i = 3; i<6; i++){
                for (int j = 6; j<9;j++){
                    if (matriz[i][j]==n){
                        res = false;
                    }
                }
            }
        }
        //Septimo cuadrante 
        if (res && 6<r && r<=9 && 0<c && c<=3){
            for (int i = 6; i<9; i++){
                for (int j = 0; j<3;j++){
                    if (matriz[i][j]==n){
                        res = false;
                    }
                }
            }
        }
        //Octavo cuadrante 
        if (res && 6<r && r<=9 && 3<c && c<=6){
            for (int i = 6; i<9; i++){
                for (int j = 3; j<6;j++){
                    if (matriz[i][j]==n){
                        res = false;
                    }
                }
            }
        }
        //Novendo cuadante
        if (res && 6<r && r<=9 && 6<c && c<=9){
            for (int i = 6; i<9; i++){
                for (int j = 6; j<9;j++){
                    if (matriz[i][j]==n){
                        res = false;
                    }
                }
            }
        }
        return res;
    }
    public static boolean revisaCasilla(int matriz [][], int r, int c, int n){
        boolean res = true;
        int i = 0;
        int j = 0;
        //Checa el renglon
        while (res && i < 9){
            if (matriz[r-1][i] == n){
                res = false;
            }
            i++;
        }
        //Checa la columna
        while (res && j < 9){
            if (matriz[j][c-1] == n){
                res = false;
            }
            if (j+1 == r-1){
                j++;
            }
            j++;
        }
        //Checa el cuadrante
        if (res){
            res = revisaCuadrante(matriz, n, r, c);
        }
        return res;
    }
    
    public static boolean encontrarEspacio(int matriz [][], int pos[]){
        boolean res = false;
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                if (matriz[i][j] == 0){
                    pos[0] = i+1;
                    pos[1] = j+1;
                    res = true;
                }
            }
        }
        return res;
    }
    
    public static boolean llenaSodoku(int matriz[][]){
        int pos [] = {0,0};
        
        if (!encontrarEspacio(matriz, pos)){
            return true;
        }
        int r = pos[0];
        int c = pos[1];
        for (int i = 1; i<10; i++){
            if (revisaCasilla(matriz, r, c, i)){
                matriz[r-1][c-1] = i;
                if(llenaSodoku(matriz)){
                    return true;
                }
                else{
                    matriz[r-1][c-1] = 0;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int sodoku [][]= {{6,5,3,1,8,7,4,0,0},
                          {8,9,2,6,4,3,1,7,5},
                          {4,7,1,9,2,5,8,3,6},
                          {3,0,8,0,0,9,0,0,1},
                          {1,0,7,0,3,2,0,0,8},
                          {5,0,9,8,0,1,3,4,0},
                          {0,3,5,0,1,4,6,8,0},
                          {7,1,6,3,9,8,2,5,4},
                          {0,8,4,0,5,6,0,1,3}};
        System.out.println(imprimeMatriz(sodoku, 9, 9));
        llenaSodoku(sodoku);
        System.out.println(imprimeMatriz(sodoku, 9, 9));
    }
}

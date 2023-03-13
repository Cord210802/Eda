/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso;

/**
 *
 * @author jupac
 */
public class Clase16 {
    //Medida de levenchtain 
    public static int minimo(int f1, int f2, int f3){
        int res = 0;
        if (f1<=f2 && f1 <= f3){
            System.out.println("inserta");
            res = f1;
        }
        else{
            if (f2<=f1 && f2<=f3){
                System.out.println("borra");
                res = f2;
            }
            else{
                if (f3<=f1 && f3<=f2){
                    System.out.println("cambia");
                    res = f3;
                }
            }
        }
        return res;
    }
    
    public static int distancia(String s1, String s2, int cont){
        if(s1.length() == 0 || s2.length()==0){
            return s2.length() + cont + s1.length();
        }
        if (s1.charAt(0) == s2.charAt(0)){
            return distancia(s1.substring(1),s2.substring(1), cont);
        }
        else{
            //universo que inserta
            int f1 = distancia(s1.substring(1), s2, cont+1);
            //universo que borra
            int f2 = distancia(s1, s2.substring(1), cont+1);
            //universo que cambia
            int f3 = distancia(s1.substring(1),s2.substring(1), cont +1);
            return minimo(f1, f2, f3);
        }
    }
    
    private static void permutacion(String residuo, String s2){
        if (residuo.length() == 0){
            System.out.println(s2);
        }
        else{
            for (int i = 0; i < residuo.length(); i++){
                char primeraLetra = residuo.charAt(i);
                String residuo2 = residuo.substring(0, i) + residuo.substring(i+1);
                permutacion(residuo2, s2 + primeraLetra);
            }
        }
    }
    
    public static void permuta(String frase){
        permutacion(frase, "");
    }
    
    public static void main(String[] args) {
        permuta("rnva");
    }
}

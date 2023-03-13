/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pila;

/**
 *
 * @author jupac
 */
public class Ejercicio12{
    private String cad;

    public Ejercicio12(String cad) {
        this.cad = cad;
    }
    
    public boolean revisaCadena(){
        PilaA<Character> pila = new PilaA();
        boolean res = true;
        int cont = 0;
        char letra;
        
        while(cont < cad.length() && res){
            letra = cad.charAt(cont);
            if(letra=='('){
                pila.push(letra);
            }
            else{
                if(letra==')'){
                    if(!pila.isEmpty()){
                        pila.pop();
                    }
                    else{
                        res = false;
                    }
                }
            }
            cont++;
        }
        
        if(res && !pila.isEmpty()){
            res = false;
        }
        return res;
    }
}

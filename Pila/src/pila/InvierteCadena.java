/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pila;

/**
 *
 * @author jupac
 */
public class InvierteCadena {
    private String cad;
    private String cadInvertida;

    public InvierteCadena(String cad) {
        this.cad = cad;
        this.cadInvertida = "";
    }
    
    public void realizarInversion(){
        PilaA<Character> pila = new PilaA();
        char letra;
        StringBuilder s = new StringBuilder();
        for(int i = 0; i<cad.length(); i++){
            letra = cad.charAt(i);
            pila.push(letra);
        }
        while(!pila.isEmpty()){
            s.append(pila.pop());
        }
        cadInvertida = s.toString();
    }

    public String getCad() {
        return cad;
    }

    public String getCadInvertida() {
        return cadInvertida;
    }
    
    
}

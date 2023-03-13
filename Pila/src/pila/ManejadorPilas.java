/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila;

import java.util.ArrayList;

/**
 *
 * @author jupac
 */
public class ManejadorPilas {
    //Ponemos PilaADT para poder usar pilas con memoria dinamica
    private static <T> int elementosPila(PilaADT<T> pil){
        int res = 0;
        PilaA<T> pilaux= new PilaA();
        
        while(!pil.isEmpty()){
            pilaux.push(pil.pop());
            res++;
        }
        while(!pilaux.isEmpty()){
            pil.push(pilaux.pop());
        }
        return res;
    }
    
    private static <T> boolean contienePila(PilaADT<T> pila1, PilaA<T>pila2){
        boolean res = true;
        PilaA<T> aux = new PilaA();
        int k = 0;
        int j = 0;
        int numElemP1 = elementosPila(pila1);
        int numElemP2 = elementosPila(pila2);
        ArrayList<T> arr1 = new ArrayList();
        ArrayList<T> arr2 = new ArrayList();
        
        if (numElemP1 <= numElemP2){
            while(!pila1.isEmpty()){
                arr1.add(pila1.pop());
            }
            while(!pila2.isEmpty()){
                arr2.add(pila2.pop());
            }
            for (int i = arr1.size()-1; i>=0; i--){
                pila1.push(arr1.get(i));
            }
            for (int i = arr1.size()-1; i>=0; i--){
                pila2.push(arr2.get(i));
            }
            while(k < arr1.size()-1 && res == true){
                if(!arr2.contains(arr1.get(k))){
                    res = false;
                }
                k++;
            }
        }
        else {
            res = false;
        }
        return res;
    }
    
    private static <T> void invierteElementos(PilaADT<T> pil){
        ArrayList<T> arr = new ArrayList();
        
        while(!pil.isEmpty()){
            arr.add(pil.pop());
        }
        for (int i = 0; i < arr.size();i++){
            pil.push(arr.get(i));
        }
    }
    
    private static <T> void eliminaRepetidos(PilaADT<T> pil){
        PilaA <T> aux1 = new PilaA();
        
        while(!pil.isEmpty()){
            if (aux1.isEmpty()){
                aux1.push(pil.pop());
            }
            else{
                if(aux1.peek()!=pil.peek()){
                    aux1.push(pil.pop());
                }
                else{
                    pil.pop();
                }
            }
        }
        while(!aux1.isEmpty()){
            pil.push(aux1.pop());
        }
    }
    
    private static boolean revisaCadena(String cad){
        PilaA<Character> pila = new PilaA();
        PilaA<Character> pila2 = new PilaA();
        PilaA<Character> pila3 = new PilaA();
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
            if(letra=='{'){
                pila2.push(letra);
            }
            else{
                if(letra=='}'){
                    if(!pila2.isEmpty()){
                        pila2.pop();
                    }
                    else{
                        res = false;
                    }
                }
            }
            if(letra=='['){
                pila3.push(letra);
            }
            else{
                if(letra==']'){
                    if(!pila3.isEmpty()){
                        pila3.pop();
                    }
                    else{
                        res = false;
                    }
                }
            }
            cont++;
        }
        if(res && !pila.isEmpty() || !pila2.isEmpty() || !pila3.isEmpty()){
            res = false;
        }
        return res;
    }
    
    public static  int numeroBinario(int numero){
        PilaA <Integer> pila = new PilaA();
        int res;
        int num = numero;
        StringBuilder cad = new StringBuilder();
        if (numero == 0){
            res = 0;
        }
        else{
            while (num>0){
            pila.push(num%2);
            num /= 2;
        }
        while(!pila.isEmpty()){
            cad.append(pila.peek());
            pila.pop();
        }
        res = Integer.parseInt(cad.toString());
        }
        return res;
    }
    
    public static <T> void quitaElementos(PilaADT<T> pila, int num){
        ArrayList<T> arr = new ArrayList();
        int cont = elementosPila(pila);
        
        if (cont>num){
            while(!pila.isEmpty()){
                arr.add(pila.pop());
            }
            for (int i = cont-1; i>=num; i--){
                pila.push(arr.get(i));
            }
        }
    }
    
    public static void inviertePilas(PilaA<Integer> p1, PilaA<Integer> p2){
        PilaA<Integer> aux = new PilaA();
        
        while(!p1.isEmpty()){
            aux.push(p1.pop());
        }
        while(!p2.isEmpty()){
            p1.push(p2.pop());
        }
        while(!aux.isEmpty()){
            p2.push(aux.pop());
        }
        aux = p1;
        System.out.println(aux.toString());
        while(!p1.isEmpty()){
            p1.pop();
        }
        System.out.println(aux.peek());
        while(!aux.isEmpty()){
            p1.push(aux.pop());
            System.out.println("hola");
        }
    }
    
    public static void main(String[] args) {
        PilaA<Integer> pil = new PilaA();
        PilaA<Integer> pil2 = new PilaA();
        Integer entero = 4;
        String s = "(4+{3*[5+3}+4)";
        pil.push(1);
        pil.push(2);
        pil.push(3);
        pil.push(4);
        pil.push(5);
        pil2.push(10);
        pil2.push(9);
        pil2.push(8);
        pil2.push(7);
        pil2.push(6);
        //ManejadorPilas.elementosPila(pil);
        //System.out.println(ManejadorPilas.elementosPila(pil));
        //ManejadorPilas.invierteElementos(pil);
        //ManejadorPilas.eliminaRepetidos(pil);
//        System.out.println(pil.toString());
//        System.out.println(revisaCadena(s));
//        System.out.println(numeroBinario(23));
//        System.out.println(contienePila(pil, pil2));
//        quitaElementos(pil, 1);
//        System.out.println(pil.toString());
        inviertePilas(pil, pil2);
        System.out.println(pil.toString());
        System.out.println("Hola");
    }
}

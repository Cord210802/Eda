
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class ConjuntoA <T> implements ConjuntoADT<T>{
    private T[] conjunto;
    private int cardinalidad;
    private final int MAX = 20;
    
    public ConjuntoA(){
        conjunto = (T[]) new Object [MAX];
        cardinalidad = 0;
    }
    
    public ConjuntoA(int max){
        conjunto = (T[]) new Object [max];
        cardinalidad = 0;
    }
    
    public Iterator<T> iterator(){
        return new IteradorArreglo(conjunto, cardinalidad);
    }
    
    public boolean contiene(T dato){
        Iterator <T> it = iterator();
        boolean bandera = false;
        
        while(it.hasNext() && !bandera){
            bandera = dato.equals(it.next());
        }
        return bandera;
    }
            
    private void expande(){
        T [] masGrande = (T[]) new Object [conjunto.length * 2];
        for (int i = 0; i < cardinalidad; i++){
            masGrande[i] = conjunto[i];
        }
        conjunto = masGrande;
    }
    
    public boolean agrega(T dato) {
        boolean res = false;
        
        if(!contiene(dato)){
            if(cardinalidad == conjunto.length )//indica que el conjunto está lleno
                expande();
            conjunto[cardinalidad] = dato;
            cardinalidad++;
            res = true;
        }
        return res;
    }
    
    public T elimina(T dato) {
        T resultado = null;
        int cont = 0;
        while (cont < cardinalidad && !conjunto[cont].equals(dato))
            cont++;
        if (cont < cardinalidad){
            resultado = conjunto[cont];
            conjunto[cont] = conjunto[cardinalidad - 1];
            conjunto[cardinalidad - 1] = null;
            cardinalidad--;
        }
        return resultado;
    }
    
    public boolean estaVacio(){
        return cardinalidad==0;
    }

    public int getCardinalidad() {
        return cardinalidad;
    }
    
    public boolean equals(Object obj) {
        boolean respuesta;
        if(this == obj)
            respuesta = true;
        else
            if(obj == null || this.getClass()!= obj.getClass())
                respuesta = false;
            else{
                ConjuntoA<T> otro = (ConjuntoA) obj;
                if(this.cardinalidad == otro.cardinalidad){
                   respuesta = true;
                   int cont = 0;
                   while (cont <= cardinalidad - 1 && respuesta){
                       if(!this.conjunto[cont].equals(otro.conjunto[cont]))
                           respuesta = false;
                       cont++;
                   }
                }
                else
                    respuesta = false;
            }
        return respuesta;
    }
    
    public String toString(){
        StringBuilder cad = new StringBuilder();
        
        return toString(cad, 0);
    }
    
    private String toString(StringBuilder sB, int indice){
        if (indice == cardinalidad){
            return sB.toString();
        }
        else{
            sB.append(conjunto[indice].toString()).append(" ");
            return toString(sB, indice + 1);
        }
    }

    @Override
    public ConjuntoADT<T> union(ConjuntoADT<T> otro){
        ConjuntoADT<T> conjUnion;
        
        if (otro == null){
            throw new RuntimeException("No es un conjunto");
        }
        conjUnion = new ConjuntoA(cardinalidad + otro.getCardinalidad());
        if (this == otro){
            copiaThisAUnion(conjUnion);
        }
        else{
            if (cardinalidad > otro.getCardinalidad()){
                copiaThisAUnion(conjUnion);
                copiaOtroAUnion(otro, conjUnion);
            }
            else{
                copiaOtroAUnionVacia(otro, conjUnion);
                copiaOtroAUnion(this, conjUnion);
            }
        }
        return conjUnion;
    }
    
    private void copiaThisAUnion(ConjuntoADT<T> destino){
        ConjuntoA temp = (ConjuntoA) destino;
        for (int i = 0; i < cardinalidad; i++){
            temp.conjunto[i] = this.conjunto[i];
        }
        temp.cardinalidad = this.cardinalidad;
    }
    
    private void copiaOtroAUnion(ConjuntoADT<T> origen,ConjuntoADT<T> destino){
        for (T elemento: origen){
            destino.agrega(elemento);
        }
    }
    
    private void copiaOtroAUnionVacia(ConjuntoADT<T> otro,ConjuntoADT<T> conjUnion){
        ConjuntoA temp = (ConjuntoA) conjUnion;
        
        for (T elemento: otro){
            temp.conjunto[temp.cardinalidad] = elemento;
            temp.cardinalidad++;
        }
    }
    
    private void añadeInter(ConjuntoADT<T> otro, ConjuntoADT<T> destino){
        int j = 0;
        ConjuntoA temp = (ConjuntoA)destino;
        
        for (int i = 0; i < cardinalidad; i++){
            if (otro.contiene(conjunto[i])){
                temp.conjunto[j] = conjunto[i];
                System.out.println(temp.conjunto[j]);
                j++;
            }
        }
        temp.cardinalidad = j;
    }
    
    private void añadeInterOtro(ConjuntoADT<T> otro, ConjuntoADT<T> destino){
        ConjuntoA temp = (ConjuntoA)destino;
        int j = 0;
        
        for(T elemento: otro){
            if (this.contiene(elemento)){
                temp.conjunto[j] = elemento;
                j++;
            }
        }
        temp.cardinalidad = j;
    }
    
    public ConjuntoADT<T> interseccion (ConjuntoADT<T> otro){
        ConjuntoADT<T> conjI;
        
        if (otro == null){
            throw new RuntimeException("No es un conjunto");
        }
        if (cardinalidad < otro.getCardinalidad()){
            conjI = new ConjuntoA(cardinalidad);
            añadeInter(otro, conjI);
        }
        else{
            conjI = new ConjuntoA(otro.getCardinalidad());
            añadeInterOtro(otro, conjI);
        }
        return conjI;
    }
    
    public ConjuntoADT<T> resta(ConjuntoADT<T> otro){
        ConjuntoADT<T> conjI;
        
        if (otro == null){
            throw new RuntimeException("No es un conjunto");
        }
        if (cardinalidad > otro.getCardinalidad()){
            conjI = new ConjuntoA(cardinalidad);
        }
        else{
            conjI = new ConjuntoA(otro.getCardinalidad());
        }
        añadeResta(otro, conjI);
        return conjI;
    }
    
    private void añadeResta(ConjuntoADT<T> otro, ConjuntoADT<T> destino){
        ConjuntoA temp = (ConjuntoA)destino;
        
        for (T elemento: this){
            if (!otro.contiene(elemento)){
                temp.conjunto[temp.cardinalidad] = elemento;
                temp.cardinalidad++;
            }
        }
    }
}

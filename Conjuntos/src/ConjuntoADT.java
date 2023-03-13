/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author jupac
 */
public interface ConjuntoADT <T> extends Iterable <T>{
    public boolean agrega(T dato);
    public T elimina(T dato);
    public boolean contiene(T dato);
    public boolean estaVacio();
    public int getCardinalidad();
    public ConjuntoADT<T> union(ConjuntoADT<T> otro);
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro);
    public ConjuntoADT<T> resta(ConjuntoADT<T> otro);
}

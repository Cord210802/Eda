
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author jupac
 */
public interface BolsaADT<T> extends Iterable <T>{
    public void agrega(T dato);
    public boolean contiene(T dato, int n);
    public int getCantidad();
    public Iterator<T> iterator();
    public void quita(T dato);
    public BolsaADT<T> junta (BolsaADT<T> otra);
}

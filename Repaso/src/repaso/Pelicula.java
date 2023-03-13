/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso;

/**
 *
 * @author jupac
 */
public class Pelicula implements Comparable{
    
    public Integer codigo;
    public String fecha;
    public String nombre;

    public Pelicula(Integer codigo, String fecha, String nombre) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.nombre = nombre;
    }
    
    @Override
    public int compareTo(Object otro) {
        if (otro instanceof Pelicula){
            return this.codigo.compareTo(((Pelicula)otro).codigo);
        }
        else{
            throw new RuntimeException();
        }
    }
    
    public String toString(){
        return codigo+"";
    }
}

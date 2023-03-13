
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jupac
 */
public class Persona {
    private String fechaNac;
    private String nombre;
    
    public Persona(String fecha, String nombre){
        this.fechaNac = fecha;
        this.nombre = nombre;
    }
    
    public int calcEdad(){
        String s;
        int fecha;
        
        s = this.fechaNac.substring(6);
        fecha = Integer.parseInt(s);
        return 2022 - fecha;
    }

    @Override
    public String toString() {
        return "Persona{" + "fechaNac=" + fechaNac + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.nombre, other.nombre);
    }
}

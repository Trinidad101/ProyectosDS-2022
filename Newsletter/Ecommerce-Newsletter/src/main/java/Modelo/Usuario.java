
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int ID;
    private String nombre;
    private String apellido;
    private String correo;
    private boolean aceptaNovedades;
   // private List<String> destinatarios;

    public Usuario(int ID, String nombre, String apellido, String correo, boolean aceptaNovedades) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.aceptaNovedades = aceptaNovedades;
    }

    public Usuario() {
    }

    /*public Usuario() {
        destinatarios = new ArrayList<>();
    }*/
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isAceptaNovedades() {
        return aceptaNovedades;
    }

    public void setAceptaNovedades(boolean aceptaNovedades) {
        this.aceptaNovedades = aceptaNovedades;
    }

   /* public List<String> getDestinatarios() {
        return destinatarios;
    }*/

    /*public void setDestinatarios(List<String> destinatarios) {
        this.destinatarios = destinatarios;
    }
*/
    
    @Override
    public String toString() {
        return "Usuario{" + "ID=" + ID + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", aceptaNovedades=" + aceptaNovedades + '}';
    }
    
    
}

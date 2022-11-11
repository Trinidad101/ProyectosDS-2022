
package Modelo;


public class Main {

  
    public static void main(String[] args) {
     
        Archivo archivo = new Archivo();
        archivo.LeerJsonUsuarios();
        archivo.LeerJsonPromociones();
        archivo.MostrarVentanaCorreo();
    }
    
}


package Controlador;
import Modelo.*;

public class Principal {

    public static void main(String[] args) {
        
        Conexion conexion = new Conexion();
        conexion.ConectarBD();
        
        InicioController.MostrarVentana();
        
    }
}
    
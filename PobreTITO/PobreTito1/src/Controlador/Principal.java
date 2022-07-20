
package Controlador;
import Modelo.*;

public class Principal {

    public static void main(String[] args) {
        
        RegistroUsuarios r = new RegistroUsuarios();
        r.RegistrarUsuarios();
        
        InicioController.MostrarVentana();
    }
    
}

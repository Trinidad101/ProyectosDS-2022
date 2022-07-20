
package Controlador;
import vistas.*;

public class PrincipalController {
    
     public static vistaPrincipal ventana = new vistaPrincipal();
    
    
    public static void MostrarVentana(){
        ventana.setVisible(true);
    }
    
    public static void OcultarVentana(){
        ventana.setVisible(false);
    }
}

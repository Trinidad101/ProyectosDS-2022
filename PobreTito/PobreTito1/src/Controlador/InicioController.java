
package Controlador;
import Modelo.Conexion;
import Modelo.*;
import javax.swing.JOptionPane;
import vistas.*;

public class InicioController {
    
    public static RegistroUsuarios registroUsuario;
    public static vistaLogin ventana = new vistaLogin();
    
    public static void MostrarVentana(){
        ventana.setVisible(true);
    }
    
    public static void OcultarVentana(){
        ventana.setVisible(false);
    }
    
    public static void eventoBotonInicio(){
        Conexion conexion = new Conexion();
        String nombreUsuario;
        String clave;
        
        boolean correcto;
        
        nombreUsuario = ventana.getTextUsuario().getText();
        clave = ventana.getTxtContraseña().getText();
        
        correcto = conexion.VerificarCuenta(nombreUsuario, clave);
        //correcto = registroUsuario.VerificarUsuario(nombreUsuario,clave);
        if(correcto){
           
            OcultarVentana();
            PrincipalController.MostrarVentana();
        }
        else{
            JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecto");
            LimpiarCeldas();
        }
    }
    
    public static void LimpiarCeldas(){
        ventana.getTxtContraseña().setText("");
        ventana.getTextUsuario().setText("");
    }
}

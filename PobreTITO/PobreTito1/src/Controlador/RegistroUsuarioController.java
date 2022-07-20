
package Controlador;
import Modelo.*;
import java.text.SimpleDateFormat;
import vistas.*;

public class RegistroUsuarioController {
    
    public static vistaRegistroUsuario ventana = new vistaRegistroUsuario();
    public static RegistroUsuarios registroUsuarios;
    
    
    public static void MostrarVentana(){
        ventana.setVisible(true);
    }
    
    public static void OcultarVentana(){
        ventana.setVisible(false);
    }
    
    public static void eventoBtnCrearCuenta(){
        
        SimpleDateFormat Formato = new SimpleDateFormat("dd-MM-yyyy");
        String nombre;
        String apellido;
        String correoElectronico;
        String fechaNacimiento;
        String nombreUsuario;
        String contraseña;
        
        nombre = ventana.getTxtNombre().getText();
        apellido = ventana.getTxtApellido().getText();
        nombreUsuario = ventana.getTxtNombreUsuario().getText();
        fechaNacimiento = Formato.format(ventana.getjDateChooser1().getDate());
        correoElectronico = ventana.getTxtCorreoElectronico().getText();
        contraseña = ventana.getTxtContraseña().getText();
        
        registroUsuarios.CrearCuenta(nombre, apellido,fechaNacimiento, nombreUsuario,correoElectronico, contraseña);
        registroUsuarios.MostrarUsuarios();
    }
}

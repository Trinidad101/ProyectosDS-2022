package Controlador;

import Modelo.Conexion;
import Modelo.*;
import java.text.SimpleDateFormat;
import vistas.*;

public class RegistroUsuarioController {

    public static vistaRegistroUsuario ventana = new vistaRegistroUsuario();
    public static RegistroUsuarios registroUsuarios;

    public static void MostrarVentana() {
        ventana.setVisible(true);
    }

    public static void OcultarVentana() {
        ventana.setVisible(false);
    }

    public static void eventoBtnCrearCuenta() {
        Conexion conexion = new Conexion();
        SimpleDateFormat Formato = new SimpleDateFormat("dd-MM-yyyy");
        String nombre;
        String apellido;
        String correoElectronico;
        String fechaNacimiento;
        String nombreUsuario;
        String contraseña;
        String dni;

        dni = ventana.getTxtDni().getText();
        nombre = ventana.getTxtNombre().getText();
        apellido = ventana.getTxtApellido().getText();
        nombreUsuario = ventana.getTxtNombreUsuario().getText();
        fechaNacimiento = Formato.format(ventana.getjDateChooser1().getDate());
        correoElectronico = ventana.getTxtCorreoElectronico().getText();
        contraseña = ventana.getTxtContraseña().getText();

        conexion.registrarUsuarios(dni,nombre, apellido, fechaNacimiento,nombreUsuario, correoElectronico, contraseña);
        
    }

}

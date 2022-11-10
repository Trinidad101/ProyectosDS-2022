package Controlador;

import vistas.*;
import Modelo.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroReclamoController1 {

    public static vistaReclamo1 ventana = new vistaReclamo1();
    public static Usuario usuario;
    public static Reclamo reclamo;
    public static Categoria categoria;
   

    public static void MostrarVentana() {
        ventana.setVisible(true);
    }

    public static void OcultarVentana() {
        ventana.setVisible(false);
    }

    public static void eventoBtnRegistrarReclamo(int categoriaSeleccionada,int subcategoriaSeleccionada) {
        Conexion conexion = new Conexion();
        String direccion;
        String descripcion;
        String fecha;
        String correoUsuario;
        
        fecha = ventana.getTxtFechaActual().getText();
        direccion = ventana.getTxtDireccion().getText();
        descripcion = ventana.getjTxtDescripcion().getText();
        correoUsuario = ventana.getTxtCorreo().getText();
        conexion.registrarReclamos(fecha, direccion, correoUsuario, categoriaSeleccionada, subcategoriaSeleccionada, descripcion);
    }

    
    public static void LimpiarCeldas() {
        ventana.getTxtDireccion().setText("");
        ventana.getjTxtDescripcion().setText("");
        ventana.getTxtCorreo().setText("");
    }


    public static String FechaActual(){
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        
        return formatoFecha.format(fecha);
    }
}

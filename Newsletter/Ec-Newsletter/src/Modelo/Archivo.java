
package Modelo;

import Vista.Correo;
import Vista.Historial;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Archivo {
    
    public ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<String> correos = new ArrayList<>();
    public static ArrayList<Promocion> promociones = new ArrayList<>();
    public static ArrayList<Promocion> listaPromociones = new ArrayList<>();
    public static ArrayList<Newsletter> newsletters = new ArrayList<>();
    public static Correo ventanaCorreo = new Correo();
    public static Historial ventanaHistorial = new Historial();
    public static Newsletter newsletter1;
    Gson gson = new Gson();

    public void MostrarVentanaCorreo() {
        ventanaCorreo.setVisible(true);
    }

    public static void MostrarVentanaHistorial() {
        ventanaHistorial.setVisible(true);
    }
    
    public void LeerJsonUsuarios() {

        String jsonSimple = "{'ID':0001,'nombre':'Trinidad','apellido':'Tessio','fechaNacimiento':'13/01/1999','dni':'41565856','domicilio':'Rioja 515','telefono':'356415886663','correo':'triniutn@gmail.com','contraseña':'65465','aceptaNovedades': true}";
        String jsonSimple1 = "{'ID':0002,'nombre':'Nicolas','apellido':'Perez','fechaNacimiento':'23/10/1986','dni':'39454556','domicilio':'Salta 558','telefono':'356415882333','correo':'NP24@gmail.com','contraseña':'36255','aceptaNovedades': true}";
        String jsonSimple2 = "{'ID':0003,'nombre':'Ariel','apellido':'Fernandez','fechaNacimiento':'15/06/1996','dni':'40254856','domicilio':'Misiones 185','telefono':'356415863848','correo':'Ariel18@gmail.com','contraseña':'1234','aceptaNovedades': false}";
        Usuario usuario1 = gson.fromJson(jsonSimple, Usuario.class);
        Usuario usuario2 = gson.fromJson(jsonSimple1, Usuario.class);
        Usuario usuario3 = gson.fromJson(jsonSimple2, Usuario.class);

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        try ( PrintWriter pw = new PrintWriter(new File("ListaUsuarios.txt"))) {

            for (Usuario usuario : usuarios) {
                boolean usuarioNoValido = validarUsuario(usuario);
                boolean correoValido = correoEsCorrecto(usuario);

                if (!usuarioNoValido) {
                    if (correoValido) {
                        if (usuario.isAceptaNovedades()) {
                            correos.add(usuario.getCorreo());

                            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
                            String representacionBonita = prettyGson.toJson(usuario);

                            pw.write(representacionBonita);
                            pw.flush();
                        }
                    } else {
                        System.out.println("CORREO: " + usuario.getCorreo() + " NO ES VÁLIDO");
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void LeerJsonPromociones() {

        String jsonTexto1 = "{'Id':10251,'descripcion':'descripcion','estado': 1,'fechaInicio':'10/11/2022','fechaFinal': '10/07/2022'}";
        String jsonTexto2 = "{'Id':10661,'descripcion':'descripcion','estado': 1,'fechaInicio':'10/11/2022','fechaFinal': '15/11/2022'}";
        String jsonTexto3 = "{'Id':15968,'descripcion':'descrpcion','estado': 1,'fechaInicio':'04/11/2022','fechaFinal': '19/09/2022'}";
        Promocion promocion1 = gson.fromJson(jsonTexto1, Promocion.class);
        Promocion promocion2 = gson.fromJson(jsonTexto2, Promocion.class);
        Promocion promocion3 = gson.fromJson(jsonTexto3, Promocion.class);

        ValidarPromocion(promocion1, promocion2, promocion3);
        promociones.add(promocion1);
        promociones.add(promocion2);
        promociones.add(promocion3);
        
        
        for (int i = 0; i < promociones.size(); i++) {
            if (FechaActual().equals(promociones.get(i).getFechaInicio())) {
                listaPromociones.add(promociones.get(i));
            }
        }
        if(listaPromociones.isEmpty()){
            JOptionPane.showMessageDialog(null, "NO HAY PROMOCIONES DISPONIBLES");
            
        }
        else{
            CargarVentana();
        }
        
    }
    
    
    public static void CargarVentana() {
        
        String receptor;
        String fechaEnvio = FechaActual();
        
        for (Promocion promocion : listaPromociones) {
            for (int i = 0; i < correos.size(); i++) {

                receptor = correos.get(i);

                Newsletter newsletter = new Newsletter(fechaEnvio, "Descuento 20%", receptor, promocion);
                newsletters.add(newsletter);
                ventanaCorreo.getTxtAsunto().setText(newsletter.getAsunto());

                String mensaje = promocion.getDescripcion() + "\n VÁLIDA HASTA EL DÍA: " + promocion.getFechaFinal();
                ventanaCorreo.getTxtMensaje().setText(mensaje);

                StringBuilder direcciones = new StringBuilder();
                boolean primero = true;

                if (primero) {
                    direcciones.append(correos);
                    primero = !primero;
                } else {
                    direcciones.append(";");
                    direcciones.append(correos);
                }
                ventanaCorreo.getTxtDestinatario().setText(direcciones.toString());
            }
            
        }
    }
    
    public static void EnviarNewsletter() {
        StringBuilder direcciones = new StringBuilder();
        boolean primero = true;

        for (Newsletter newsletter : newsletters) {

            EnviarCorreo enviarCorreo = new EnviarCorreo();
            if (primero) {
                direcciones.append(newsletter);
                enviarCorreo.start();
                enviarCorreo.run(newsletter.getCorreoReceptor(), newsletter);
                primero = !primero;
            } else {
                direcciones.append(newsletter);
                enviarCorreo.start();
                enviarCorreo.run(newsletter.getCorreoReceptor(), newsletter);
            }
        }
    }
        
       
    public static void GenerarHistorial(){
        
        DefaultTableModel modelo = (DefaultTableModel) ventanaHistorial.getTblHistorial().getModel();
        Object[] objeto = new Object[3];
        
        for(Newsletter newsletter: newsletters){
            
            objeto[0] = newsletter.getFechaEnvio();
            objeto[1] = newsletter.getCorreoReceptor();
            objeto[2] = newsletter.getAsunto();
            
            modelo.addRow(objeto);
        }
    }
    
    
    public static String FechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");

        return formatoFecha.format(fecha);
    }
    
    
    public void ValidarPromocion(Promocion promocion1, Promocion promocion2, Promocion promocion3) {

        String descripcion = promocion1.getDescripcion();

        boolean isNumeric = descripcion.chars().allMatch(Character::isDigit);
        if (isNumeric) {
            System.out.println("\nDESCRIPCION: " + descripcion + " DE LA PROMOCION NO ES VÁLIDA");
        }
    }

    
    private boolean validarUsuario(Usuario usuario) {

        boolean esNumerico = false;
        String nombre = usuario.getNombre();
        String apellido = usuario.getApellido();

        for (int i = 0; i < usuarios.size(); i++) {

            if (nombre.chars().allMatch(Character::isDigit) || (apellido.chars().allMatch(Character::isDigit))) {
                esNumerico = true;
            }
        }
        if (esNumerico) {
            System.out.println("USUARIO: " + nombre + " " + apellido + " NO ES VÁLIDO");
        }
        return (esNumerico);
    }

    
    private boolean correoEsCorrecto(Usuario usuario) {

        String correo = usuario.getCorreo();

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);

        return (mather.find());
    }

}

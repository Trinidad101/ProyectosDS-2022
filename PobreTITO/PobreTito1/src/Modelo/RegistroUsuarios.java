
package Modelo;

import vistas.*;
import java.util.ArrayList;

public class RegistroUsuarios {
    
    public static ArrayList<Usuario> usuarios = new ArrayList();
  
    public  void RegistrarUsuarios(){
        
        usuarios.add(new Usuario("Usuario2","apellido2","15-05-2002","usuario2","usuario2@gmail.com","0256"));
    }
    
    public static void CrearCuenta(String nombre, String apellido,String fechaNacimiento, String nombreUsuario,String correoElectronico, String contraseña){
        
        usuarios.add(new Usuario(nombre,apellido,fechaNacimiento,nombreUsuario,correoElectronico,contraseña));
        
    }    
    
    public static Boolean VerificarUsuario (String usuario, String contraseña){
        boolean resultado = false;
        //RegistrarUsuarios();
        
        for(int i=0; i<usuarios.size();i++){
            if(usuarios.get(i).getNombreUsuario().equals(usuario) && usuarios.get(i).getContraseña().equals(contraseña)){
                resultado = true;
            }
            else {
                resultado = false;
            }
        }
        return resultado;
    }
    
    public static void MostrarUsuarios(){
        
       System.out.println(" \t\tLista de Alumnos");
        int pos=1;
        for (Usuario usuario: usuarios) {
            System.out.println();
            System.out.println(usuario.nombre + " " + usuario.apellido + " " + usuario.fechaNacimiento +" " + usuario.nombreUsuario +  " "  + usuario.correoElectronico + " " + usuario.contraseña);
            pos++;
        }
        System.out.println("\n");
    }
    
}

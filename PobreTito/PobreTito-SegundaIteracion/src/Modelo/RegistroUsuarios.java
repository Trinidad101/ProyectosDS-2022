
package Modelo;

import java.util.ArrayList;

public class RegistroUsuarios {
    
    public static ArrayList<Usuario> usuarios = new ArrayList();
  
    
    public static void CrearCuenta(String nombre, String apellido,String fechaNacimiento, String nombreUsuario,String correoElectronico, String contraseña){
        
        usuarios.add(new Usuario(nombre,apellido,fechaNacimiento,nombreUsuario,correoElectronico,contraseña));
    }    
    
    public static Boolean VerificarUsuario (String usuario, String contraseña){
        boolean resultado = false;
        
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
    
}

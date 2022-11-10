package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;



public class Conexion {
    
    Connection conectar = null;
    String usuario = "root";
    String contraseña1 = "Trinid@d2016";
    String bd = "pobreTITO";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public void registrarUsuarios(String Dni,String nombre,String apellido,String fechaNacimiento,String nombreUsuario,String correoElectronico,String contraseña){
        
       try{
            ConectarBD();
            Statement s = conectar.createStatement();
            s.executeUpdate("insert into usuarios values('"+Dni+"','"+nombre+"','"+apellido+"','"+fechaNacimiento+"','"+nombreUsuario+"','"+correoElectronico+"','"+contraseña+"')");
            System.out.println("Los valores han sido agregados a la base de datos ");
            
        }catch (SQLException e){
        }
       
    }

    public boolean VerificarCuenta(String nombreUsuario,String contraseña){
        boolean estado = false;
        int resultado;
        String SQL = "select * from usuarios where NombreUsuario ='"+ nombreUsuario+"' and Contraseña='"+contraseña+"'";
        
        try{
            ConectarBD();
           Statement s = conectar.createStatement();
           ResultSet rs = s.executeQuery(SQL);
           
           if(rs.next()){
               resultado=1;
               if(resultado==1){
                 estado=true;  
                 
               }
               else{
                   estado=false;
               }
           }
        }catch (SQLException e){
    }
       return estado;
}
    
    
    public Vector<Categoria> getCategoria(){
        ConectarBD();
        
        Vector<Categoria> datos = new Vector<Categoria>();
        Categoria dat = null;
        
        try{
            Statement s = conectar.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM categorias");
            //Agregar una opcion 
            dat = new Categoria();
            dat.setIdCategoria(0);
            dat.setNombre("Seleccione la categoria");
            datos.add(dat);
            
            while(rs.next()){
                dat = new Categoria();
                dat.setIdCategoria(rs.getInt("idCategoria"));
                dat.setNombre(rs.getString("nombre"));
                datos.add(dat);
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return (datos);
    }
    
   public Vector<Subcategoria> getSubcategoria(int idCategoria){
        ConectarBD();
        
        Vector<Subcategoria> datos = new Vector<Subcategoria>();
        Subcategoria dat;
        
        try{
            Statement s = conectar.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM subcategorias WHERE idCategoria =" + idCategoria);
            //Agregar una opcion 
            dat = new Subcategoria();
            dat.setId(0);
            dat.setNombre("Seleccione el motivo");
            datos.add(dat);
            
            while(rs.next()){
                dat = new Subcategoria();
                dat.setId(rs.getInt("idSubcategoria"));
            dat.setNombre(rs.getString("nombre"));
            datos.add(dat);
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return (datos);
    }
   
    
   public void registrarReclamos(String Fecha, String Direccion,String correoUsuario, int idCategoria, int idSubcategoria, String Descripcion){
        
       try{
            ConectarBD();
            Statement s = conectar.createStatement();
            s.executeUpdate("insert into reclamos values('"+0+"','"+Fecha+"','"+Direccion+"','"+correoUsuario+"','"+idCategoria+"','"+idSubcategoria+"','"+Descripcion+"')");
            System.out.println("Los valores han sido agregados a la base de datos ");
            
        }catch (SQLException e){
        }
       
   }
   
   
    public void ConectarBD() {
        try {
            conectar = DriverManager.getConnection(cadena, usuario, contraseña1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

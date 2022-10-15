
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Archivo {
    
    public static ArrayList<Usuario> usuarios;
    
    public Archivo(){
        usuarios = new ArrayList<>();
        
    }
    
    public void LeerInformacion(){
        
        JSONParser parser = new JSONParser();

        try{
            //Se crea un objeto para guardar lo que se lee de FileReader
            Object obj = parser.parse(new FileReader("ListaUsuarios_1.json"));
            //Se almacena en un objeto JSON
            JSONObject jsonObject = (JSONObject) obj;
            //Extraer la lista JSON del objeto
            JSONArray usuariosArray = (JSONArray) jsonObject.get("Usuarios");
            
            for(int i=0; i<usuariosArray.size();i++){
                
                //se extrae el json del Array
                Object objetoUsuario = usuariosArray.get(i);
                JSONObject objetoUsuarioJson = (JSONObject) objetoUsuario;
                //se rellanan los datos correspondientes
                
                int idUsuario = (int) objetoUsuarioJson.get("id");
                String nombre = objetoUsuarioJson.get("nombre").toString();
                String apellido = objetoUsuarioJson.get("apellido").toString();
                String correo = objetoUsuarioJson.get("correo").toString();
                boolean aceptaNovedades = (boolean) objetoUsuarioJson.get("aceptaNovedades");
                
                Usuario usuario1 = new Usuario (idUsuario,nombre,apellido,correo,aceptaNovedades);
                System.out.println(idUsuario);
                usuarios.add(usuario1);
                    
       
            }
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void escribirInformacion(){
        
        
            //Crea la raiz y la lista
            JSONObject usuariosJSON = new JSONObject();
            JSONArray list = new JSONArray();
            
            for(Usuario usuario: usuarios){
                
                JSONObject uJson = new JSONObject();
                //pone "elementos con sus respectivos valore"
                
                if(usuario.isAceptaNovedades()){
                    
                    uJson.put("id", usuario.getID());
                    uJson.put("correo", usuario.getCorreo());
                    uJson.put("aceptaNovedades", usuario.isAceptaNovedades());
                    //se agrega el objeto a una lista de Json para enviar como un objeto Json
                    list.add(uJson);
                }//se agrega a usuarios la lista
                usuariosJSON.put("usuario", list);
                //se crea un archivo Json
                try(FileWriter file = new FileWriter("Usuarios.json")){
                    //se escriben los datos
                    
                    file.write(usuariosJSON.toString());
                    file.flush();
                    
                }catch(IOException ex){
                    System.out.println("Error al escribir la informacion al archivo JSon");
                }
            //fin de if
        }
    }
    
    
    public void MostrarListaUsuarios(){
        for(Usuario usuario: usuarios){
            System.out.print(usuario);
        }
    }
    
}

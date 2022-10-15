
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EnviarCorreo {
    
    String miCorreo;
    String miPassword;
    String servidorSMTP="smtp.gmail.com";
    String puertoEnvio="587";// puertoEnvio="587";//465 para mensajes normales y 587 con adjuntos
    String[] destinatarios;
    String asunto;
    String cuerpo = null;//cuerpo del mensaje
    String[] archivoAdjunto;
    
  public EnviarCorreo(String usuario,String pass,String[] dest,String asun,String mens,String[] archivo){
        destinatarios=dest;
        asunto=asun;
        cuerpo=mens;
        archivoAdjunto=archivo;  
        miCorreo=usuario;
        miPassword=pass;
     }
    
    public void Enviar() throws MessagingException
    {
            Properties props=null;
            props = new Properties();
            props.put("mail.smtp.host", servidorSMTP);
            props.setProperty("mail.smtp.starttls.enable", "true");//si usa Yahoo comentar esta linea         
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", miCorreo);
            props.setProperty("mail.smtp.auth", "true");
            SecurityManager security = System.getSecurityManager();
     
            Authenticator auth = new EnviarCorreo.autentificadorSMTP();
            Session session = Session.getInstance(props, auth);
           // session.setDebug(true); //Descomentar para ver el proceso de envio detalladamente
            
            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText(cuerpo);
            
            // Se compone el adjunto 
            BodyPart[] adjunto=new BodyPart[archivoAdjunto.length];
            for(int j=0;j<archivoAdjunto.length;j++){
            adjunto[j]=new MimeBodyPart();
            adjunto[j].setDataHandler(
                new DataHandler(new FileDataSource(archivoAdjunto[j])));
            
            String[] rutaArchivo = archivoAdjunto[j].split("/");//separamos las palabras que forman la url y las                 ponemos en arreglo  de cadenas
            int nombre=rutaArchivo.length-1;//del array buscamos la ultima posicion
            adjunto[j].setFileName(rutaArchivo[nombre]);//la ultima posicion debe tener el nombre del archivo
            }
            

            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            for(BodyPart aux:adjunto){
                multiParte.addBodyPart(aux);
            }
            

            // Se compone el correo, dando to, from, subject y el
            // contenido.
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(miCorreo));
            Address []destinos = new Address[destinatarios.length];//Aqui usamos el arreglo de destinatarios
            for(int i=0;i<destinos.length;i++){
                destinos[i]=new InternetAddress(destinatarios[i]);
            }
            message.addRecipients(Message.RecipientType.TO, destinos);//agregamos los destinatarios
            message.setSubject(asunto);
            message.setContent(multiParte);

            // Se envia el correo.
            Transport t = session.getTransport("smtp");
            t.connect(miCorreo, miPassword);
            t.sendMessage(message, message.getAllRecipients());
            System.out.println("Correo Enviado exitosamente!"); 
            t.close();    
        }
     private class autentificadorSMTP extends javax.mail.Authenticator {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(miCorreo, miPassword);
        }
    }
        
    

}

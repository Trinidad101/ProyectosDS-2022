
package Modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EnviarCorreo  extends Thread implements Serializable{
    String correoEmisor = "trinitessio101@gmail.com";
    String contraseñaEmisor = "xgyawwqwrkfvfmbi";
    public static ArrayList<String> correos = new ArrayList<>();
    
  
   
    public EnviarCorreo(String correos,Newsletter newsletter) {
	super("procesoEnvioEmail");
        String dto = correos;
        Newsletter newsletter1 = newsletter;
    }
    
    public EnviarCorreo(){}

    
    public Session connectServer() {
	// propiedades de conexion
	Properties props = new Properties();
	props.put("mail.smtp.auth", true);
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "25");
	props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	
	return Session.getInstance(props, new Authenticator() {
	
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(correoEmisor, contraseñaEmisor);
		}
	});    
    }

    
    public  void sendEmail(String correos,Newsletter newsletter1){
	// Obtenemos las direcciones/destinatarios
        String sinComillas = correos.replace("\"", "");
	// Obtenemos la conexion al servidor de correos
	Session session = connectServer();
	try {
		MimeMessage msg = new MimeMessage(session);
		
		// Asignamos el asunto del correo
		msg.setSubject(newsletter1.getAsunto(), "UTF-8");
		// Asignamos la hora de creacion del correo
		msg.setSentDate(new Date());

		Multipart multiparte = new MimeMultipart();
	
		//Creamos el cuerpo del mensaje
		BodyPart cuerpoMensaje = new MimeBodyPart();
		cuerpoMensaje.setContent(newsletter1.getPromocion().getDescripcion(), "text/html");
		multiparte.addBodyPart(cuerpoMensaje);
		
		/*//Validamos si tenemos adjuntos
		if (dto.getAdjunto() == null ? false : !dto.getAdjunto().isEmpty()) {
		// Si tenemos adjuntos los agregamos al mensaje
			for (File file : dto.getAdjunto()) {
				cuerpoMensaje = new MimeBodyPart();
				cuerpoMensaje.setDataHandler(new DataHandler(new FileDataSource(file)));
				cuerpoMensaje.setFileName(file.getName());
				multiparte.addBodyPart(cuerpoMensaje);
			}
		}*/
		msg.setContent(multiparte);
		msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(sinComillas));
		
		//Agregamos el origen del mensaje (nuestro email)
		msg.setFrom(new InternetAddress(correoEmisor));
		
		//Enviamos el mensaje
		Transport.send(msg);
                 
	} catch (MessagingException e) {}
      
}

    
    public  void run(String correos,Newsletter newsletter) {
	sendEmail(correos,newsletter);
}
    
}

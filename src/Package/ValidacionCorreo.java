package Package;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

public class ValidacionCorreo {
	
	public static void main(String args[]){
		
		int codActivacion = ThreadLocalRandom.current().nextInt(1001, 9999);
		String host ="smtp.gmail.com" ;
        String usuario = "carpoolingsabana@gmail.com";
        String contra = "profePonganos5";
        String dominio= "@unisabana.edu.co";
        String para = "indigodreamer11@hotmail.com";
        String de = "carpoolingsabana@gmail.co";
        String asunto = "Activación cuenta Carwheels sabana.";
        String mensaje = "Su código de activación es: " + codActivacion;
        boolean sessionDebug = false;
        
        if (para.contains(dominio)){
        	
        	try{
                
                Properties props = System.getProperties();

                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.required", "true");

                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                Session mailSession = Session.getDefaultInstance(props, null);
                mailSession.setDebug(sessionDebug);
                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(de));
                InternetAddress[] address = {new InternetAddress(para)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(asunto); msg.setSentDate(new Date());
                msg.setText(mensaje);

               Transport transport=mailSession.getTransport("smtp");
               transport.connect(host, usuario, contra);
               transport.sendMessage(msg, msg.getAllRecipients());
               transport.close();
               System.out.println("El código de activación ha sido enviado");
            }catch(Exception ex) {
                System.out.println(ex);
            }
        	
        } else {
        	System.out.println("Dirección de correo no valida");
        }
		
        

    }

}

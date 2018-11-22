package Package;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.mail.*;
import javax.mail.internet.*;

public class ValidacionCorreo {
	private String correo;
	private int codigo;
	private Calendar fecha;
	
	
	
	public ValidacionCorreo(String correo) throws Exception {
		super();
		this.correo = correo;
		this.codigo = this.enviarCorreo(correo);
		this.fecha = Calendar.getInstance();
	}



	private int enviarCorreo(String correo) throws Exception{
		
		int codActivacion = ThreadLocalRandom.current().nextInt(1001, 9999);
		String host ="smtp.gmail.com" ;
        String usuario = "carpoolingsabana@gmail.com";
        String contra = "profePonganos5";
        String dominio= "@unisabana.edu.co";
        String para = correo;
        String de = "carpoolingsabana@gmail.co";
        String asunto = "Activaci�n cuenta Carwheels sabana.";
        String mensaje = "Su codigo de activacion es: " + codActivacion + "\nrecuerde que este codigo vence en 24 horas";
        boolean sessionDebug = false;
        
        if (para.contains(dominio)){
        	              
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
               System.out.println("El codigo de activacion ha sido enviado");
            
        	
        } else {
        	throw new Exception("Direccion de correo no valida");
        }
		
        return codActivacion;

    }
	
	public boolean validar(int numero) throws Exception {
		Calendar ahora = Calendar.getInstance();
		boolean caducidad = false;
		if(ahora.get(Calendar.DAY_OF_YEAR) == this.fecha.get(Calendar.DAY_OF_YEAR)) {
			caducidad  = true;
		}else {
			if(ahora.get(Calendar.DAY_OF_YEAR) == (this.fecha.get(Calendar.DAY_OF_YEAR) + 1 ) && ahora.get(Calendar.HOUR_OF_DAY)< fecha.get(Calendar.HOUR_OF_DAY)) {
				caducidad = true;
			}else {
				caducidad = false;
			}
		}
		
		if(caducidad) {
			if(this.codigo == numero) {
				return true;
			}else {
				throw new Exception("codigo invalido");
			}
		}else {
			throw new Exception("el codigo de validacion ha caducado");
		}
		
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public Calendar getFecha() {
		return fecha;
	}



	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}



	
	
	
	

}

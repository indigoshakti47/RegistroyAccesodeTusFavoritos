package Package;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class Facade {
	
    private Usuarios usuarios; 
    private ArrayList<Acceso> ingresos;
    private ArrayList<Multa> multas;
    private ArrayList<Ruta> rutas;
    private ArrayList<ValidacionCorreo> validaciones;
    
    public Facade(){
        usuarios = new Usuarios();
        rutas = new ArrayList<Ruta>();
        ingresos = new ArrayList<Acceso>();
        multas = new ArrayList<Multa>();
        validaciones = new ArrayList();
    }
    
    public Usuario RegistrarUsuario(String tipo, String nombre, String correo, String contrasena) throws Exception{
        Usuario u;
        if(tipo.equals("conductor")){
            u= new Conductor();
        }else if(tipo.equals("pasajero")){
            u= new Pasajero();
        }else if(tipo.equals("administrador")){
            u = new AdministradorAdapter();
        }else{
            throw new Exception ("Tipo de usuario no especificado");
        }
        String r= u.adicionar(nombre, correo, contrasena);
        usuarios.putUsuario(u);
        validaciones.add(new ValidacionCorreo(correo));
        return u;
    }
    
    public boolean validarCorreo(String correo, int codigo) throws Exception {
    	Iterator<ValidacionCorreo>iv = validaciones.iterator();
    	ValidacionCorreo v;
    	boolean validar;
    	while(iv.hasNext()) {
    		v = iv.next();
    		if(v.getCorreo().equals(correo)) {
    			validar = v.validar(codigo);
    			this.buscarUsuario(correo).setValido(validar);
    			return validar;
    			
    		}
    	}
    	
    	return false;
    }
    
    public void eliminarUsuario(String correo){
        usuarios.removeUsuario(correo);
        ProxyMenu.UnicaInstancia().eliminar(correo);
    }
    
    public IUsuario acceder(String correo, String contrasena, long id) throws Exception{
        IUsuario user= usuarios.getUsuario(correo);
        if(user==null) throw new Exception("este usuario no esta registrado");
        
        if(user.getContrasena().equals(contrasena)){
            ingresos.add(new Acceso(correo, id));
            return user;
        }else{
            throw new Exception("Contraseña incorrecta");
        }
    }
    
    public void imponerMulta(Reserva reserva, String denunciante) throws Exception {
    	String denunciado;
    	if(denunciante.equals(reserva.getPasajero())) {
    		denunciado = comprobarRuta(reserva.getRuta()).getConductor();
    	}else if(comprobarRuta(reserva.getRuta()).getConductor().equals(denunciante)){
    		denunciado = reserva.getPasajero();
    	}else {
    		throw new Exception("denuncia invalida");
    	}
    	
    	
    	Calendar current = Calendar.getInstance();
    	Calendar res = reserva.getHora();
    	if(current.compareTo(res)<= 0) {
    		multas.add(new Multa(denunciado, reserva.getPrecio()));
    	}else {
    		long precio = (long) (reserva.getPrecio() * 1.5); 
    		multas.add(new Multa(denunciado,precio));
    	}
    }
    
    
   
    
    //-------------------------------------metodos privados (para el funcionamiento de otros)-------------
    
    
      private Usuario buscarUsuario(String correo) throws Exception{
        IUsuario u = usuarios.getUsuario(correo);
        if(u == null){
            throw new Exception("Usuario no encontrado");
        }else{
            return (Usuario) u;
        }
    }
      

    
    public boolean verificarCodigo(String correo, long codigo) throws Exception{
        for(Acceso a: ingresos){
            if(a.getKey().equals(correo) && a.getId() == codigo){
                return true;
            }
        }
        
        throw new Exception("no ha iniciado sesion");
    }
    
    private Ruta comprobarRuta(String nombre){
        for(Ruta c: rutas){
                if(c.getNombre().equals(nombre))  return c;    
        }
        return null;
    }

}

package Package;



public class Conductor extends Usuario {
	
	public Conductor() {
	    super();
	  }

	  @Override
	  public String adicionar(String nombre, String correo, String contrasena) throws Exception {
	      if(getNombre()==null && getCorreo()==null && getContrasena()==null){
	      setNombre(nombre);
	      setCorreo(correo);
	      setContrasena(contrasena);
	      }else{
	          throw new Exception("Este usuario ya tiene datos registrados");
	      }
	      
	      return "Conductor añadido exitósamente.";
	    
	  }

	  @Override
	  public String modificar(String correo, String nombre, String contrasena) throws Exception{
	      
	      if(!(getNombre()==null && getCorreo()==null && getContrasena()==null)) {
	      setNombre(nombre);
	      setCorreo(correo);
	      setContrasena(contrasena);
	      }else{
	          throw new Exception("Este usuario no tiene datos registrados aun, deberias crearlo");
	      }

	      return "COnductor modificado exitósamente.";
	    
	  }

	  @Override
	  public String consultar()  throws Exception {
	      if(getNombre()==null && getCorreo()==null && getContrasena()==null){
	          throw new Exception ("no hay datos guardados en este Usuario");
	      }
	      
	      return "Conductor: Nombre: " + getNombre() + " - correo: " + getCorreo();
	    
	  }

}

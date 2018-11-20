package Package;

public class AdministradorAdapter extends Usuario{
	private Administrador admin;

	  public AdministradorAdapter() {
	    super();
	    this.admin = new Administrador();
	  }

	  @Override
	  public String adicionar(String nombre, String correo, String contrasena,String documento, String genero, String fechaNacimiento, String foto) throws Exception {
	      if(admin.getNombre()==null && admin.getCorreo()==null && admin.getContrasena()==null){
	      admin.setNombre(nombre);
	      admin.setCorreo(correo);
	      admin.setContrasena(contrasena);
	      setGenero(genero);
	      setDocumento(documento);
	      setFoto(foto);
	      setFechaNacimiento(fechaNacimiento);
	      }else{
	          throw new Exception("Este usuario ya tiene datos registrados");
	      }
	      
	      return "Administrador añadido exitósamente.";
	    
	  }

	  @Override
	  public String modificar(String correo, String nombre, String contrasena,String documento, String genero, String fechaNacimiento, String foto) throws Exception{
	      
	      if(!(admin.getNombre()==null && admin.getCorreo()==null && admin.getContrasena()==null)) {
	      admin.setNombre(nombre);
	      admin.setCorreo(correo);
	      admin.setContrasena(contrasena);
	      setGenero(genero);
	      setDocumento(documento);
	      setFoto(foto);
	      setFechaNacimiento(fechaNacimiento);
	      }else{
	          throw new Exception("Este usuario no tiene datos registrados aun, deberias crearlo");
	      }

	      return "Administrador modificado exitósamente.";
	    
	  }

	  @Override
	  public String consultar()  throws Exception {
	      if(admin.getNombre()==null && admin.getCorreo()==null && admin.getContrasena()==null){
	          throw new Exception ("no hay datos guardados en este Usuario");
	      }
	      
	      return "Administrador: Nombre: " + admin.getNombre() + " - correo: " + admin.getCorreo();
	    
	  }

}

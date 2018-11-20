package Package;


public abstract class Usuario implements IUsuario {
	
	  protected String nombre;
	  
	  
	  protected String correo;
	  protected String contrasena;

	  abstract public String adicionar(String nombre, String correo, String contrasena) throws Exception;

	  abstract public String modificar(String correo, String nombre, String contrasena) throws Exception;

	  abstract public String consultar() throws Exception;
	  
	  



	  public Usuario() {
		super();
	}

	public String getNombre() {
	    return nombre;
	  }

	  public void setNombre(String nombre) {
	    this.nombre = nombre;
	  }

	  public String getCorreo() {
	    return correo;
	  }

	  public void setCorreo(String correo) {
	    this.correo = correo;
	  }

	  public String getContrasena() {
	    return contrasena;
	  }

	  public void setContrasena(String contrasena) {
	    this.contrasena = contrasena;
	  }

}

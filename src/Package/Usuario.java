package Package;

import java.util.Calendar;

public abstract class Usuario implements IUsuario {
	
	  protected String nombre;
	  protected String correo;
	  protected String contrasena;
	  protected String genero;
	  protected String fechaNacimiento;
	  protected String foto;
	  protected String documento;
	  
	  
	  protected boolean valido;

	  abstract public String adicionar(String nombre, String correo, String contrasena, String documento, String genero, String fechaNacimiento, String foto) throws Exception;

	  abstract public String modificar(String correo, String nombre, String contrasena, String documento, String genero, String fechaNacimiento, String foto) throws Exception;

	  abstract public String consultar() throws Exception;
	  
	  



	  public Usuario() {
		  super();
		valido=false;
	}

	  
	  
	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	  
	  
}

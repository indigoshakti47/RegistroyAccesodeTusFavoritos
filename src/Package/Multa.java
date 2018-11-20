package Package;

public class Multa {
	private String usuario;
	private long precio;
	
	public Multa(String usuario, long precio) {
		this.usuario = usuario;
		this.precio = precio;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public long getPrecio() {
		return precio;
	}
	public void setPrecio(long precio) {
		this.precio = precio;
	}
	
	

}

package Package;

public class Administrador {
	
	private String nombre;
    private String correo;
    private String contrasena;

  public void crear() {
    System.out.println("Crear adaptado...");
  }

  public void actualizar() {
    System.out.println("Actualizar adaptado...");
  }

  public void listar() {
    System.out.println("Listar adaptado...");
  }

  public void quitar() {
    System.out.println("Quitar adaptado...");
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

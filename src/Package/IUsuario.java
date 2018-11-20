package Package;

public interface IUsuario {
	
	public String adicionar(String nombre, String correo, String contrasena) throws Exception ;

    public String modificar(String correo, String nombre, String contrasena) throws Exception;

    public String consultar() throws Exception;
    
    public boolean isValido();
    
    public void setValido(boolean valido);
    
    public String getNombre() ;

   public void setNombre(String nombre);

   public String getCorreo();

   public void setCorreo(String correo);

   public String getContrasena();

   public void setContrasena(String contrasena);

}

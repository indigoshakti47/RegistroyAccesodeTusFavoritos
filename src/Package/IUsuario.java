package Package;

public interface IUsuario {
	
	public String adicionar(String nombre, String correo, String contrasena,  String documento, String genero, String fechaNacimiento, String foto) throws Exception ;

    public String modificar(String correo, String nombre, String contrasena,  String documento, String genero, String fechaNacimiento, String foto) throws Exception;

    public String consultar() throws Exception;
    
    public boolean isValido();
    
    public void setValido(boolean valido);
    
    public String getNombre() ;

   public void setNombre(String nombre);

   public String getCorreo();

   public void setCorreo(String correo);

   public String getContrasena();

   public void setContrasena(String contrasena);
   
   public String getGenero();

	public void setGenero(String genero);

	public String getFechaNacimiento();

	public void setFechaNacimiento(String fechaNacimiento);

	public String getFoto();

	public void setFoto(String foto);

	public String getDocumento();
	
	public void setDocumento(String documento);

}

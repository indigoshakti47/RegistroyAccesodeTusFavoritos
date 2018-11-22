package Package;

import java.util.ArrayList;

public interface Imenu {

	 public ArrayList<String> acceder(String correo, String contrasena) throws Exception;
	    public void registrarUsuario(String tipoUsuario, String nombre, String correo, String contrasena, String documento, String genero, String fechaNacimiento, String foto) throws Exception;
	}
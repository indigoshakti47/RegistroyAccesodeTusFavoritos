package Package;

import java.util.HashMap;

public class Usuarios {
	
private HashMap<String, IUsuario> usuarios;
    
    public Usuarios(){
        usuarios = new HashMap<String, IUsuario>();
    }
    
    public IUsuario getUsuario(String key){
        return usuarios.get(key);
    }
    
    public void putUsuario(IUsuario usuario){
        usuarios.put(usuario.getCorreo(), usuario);
    }

    public HashMap<String, IUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(HashMap<String, IUsuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void removeUsuario(String key){
        usuarios.remove(key);
    }

}

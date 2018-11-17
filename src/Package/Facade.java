package Package;

import java.util.ArrayList;

public class Facade {
	
    private Usuarios usuarios; 
    private ArrayList<Acceso> ingresos;
    
    public Facade(){
        usuarios = new Usuarios();
       
        ingresos = new ArrayList<Acceso>();
        
    }
    
    public Usuario RegistrarUsuario(String tipo, String nombre, String correo, String contraseña) throws Exception{
        Usuario u;
        if(tipo.equals("conductor")){
            u= new Conductor();
        }else if(tipo.equals("pasajero")){
            u= new Pasajero();
        }else if(tipo.equals("administrador")){
            u = new AdministradorAdapter();
        }else{
            throw new Exception ("Tipo de usuario no especificado");
        }
        String r= u.adicionar(nombre, correo, contraseña);
        usuarios.putUsuario(u);
        return u;
    }
    
    public void eliminarUsuario(String correo){
        usuarios.removeUsuario(correo);
        ProxyMenu.UnicaInstancia().eliminar(correo);
    }
    
    public IUsuario acceder(String correo, String contraseña, long id) throws Exception{
        IUsuario user= usuarios.getUsuario(correo);
        if(user==null) throw new Exception("este usuario no esta registrado");
        
        if(user.getContraseña().equals(contraseña)){
            ingresos.add(new Acceso(correo, id));
            return user;
        }else{
            throw new Exception("Contraseña incorrecta");
        }
    }
    
   
    
    //-------------------------------------metodos privados (para el funcionamiento de otros)-------------
    
    
      private Usuario buscarUsuario(String correo) throws Exception{
        IUsuario u = usuarios.getUsuario(correo);
        if(u == null){
            throw new Exception("Usuario no encontrado");
        }else{
            return (Usuario) u;
        }
    }
      

    
    public boolean verificarCodigo(String correo, long codigo) throws Exception{
        for(Acceso a: ingresos){
            if(a.getKey().equals(correo) && a.getId() == codigo){
                return true;
            }
        }
        
        throw new Exception("no ha iniciado sesion");
    }

}

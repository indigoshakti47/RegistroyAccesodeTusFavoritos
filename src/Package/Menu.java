package Package;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int pasajeros, op = -1;
	        String nombre, correo, contrasena, tipo, salida, hora, conductor, pasajero;
	        long valor; 
	        ArrayList<String> datos;
	        do {
	            try{
	            op = Integer.parseInt(JOptionPane.showInputDialog("Que opcion desea?: \n"
	                    + "1) REGISTRAR UN USUARIO\n"
	                    + "2) ACCEDER AL SISTEMA\n"                    
	                    + "0) SALIR"));
	            
	                switch (op) {

	                    case 1:
	                        nombre= JOptionPane.showInputDialog("¿Cual es su nombre?");
	                        correo= JOptionPane.showInputDialog("indique su correo electronico");
	                        contrasena = JOptionPane.showInputDialog("escriba una constraseña");
	                        int t= Integer.parseInt(JOptionPane.showInputDialog("1. administrador\n2.pasajero\n3.conductor"));
	                        switch(t){
	                            case 1: tipo = "administrador"; break;
	                            case 2: tipo = "pasajero"; break;
	                            case 3: tipo = "conductor"; break;
	                            default: tipo = null; break;
	                        }
	                        ProxyMenu.UnicaInstancia().registrarUsuario(tipo, nombre, correo, contrasena);
	                        break;
	                    case 2:
	                        correo= JOptionPane.showInputDialog("ingrese su correo");
	                        contrasena = JOptionPane.showInputDialog("ingrese su contraseña");
	                        datos= ProxyMenu.UnicaInstancia().acceder(correo, contrasena);
	                        Menu.mostrarMenu(datos);
	                        break;
	                    case 0:
	                    JOptionPane.showMessageDialog(null, "Saliendo del sistema!","Despedida",2);
	                break;
	                default:
	                    JOptionPane.showMessageDialog(null, "ESE CASO NO EXISTE..!","Error",0);
	                break;
	                
	                }
	            }catch(Exception e){
	                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
	            } 
	        }
	        while (op !=0);
	    }

	 private static void mostrarMenu(ArrayList<String> mensaje) throws Exception{
	       String hora,ruta, pasajero, bruta, banco, tipocuenta, cuenta,conductor, tarjeta, codigo,salida;
	       String tipo, nombre, correo, contrase�a;
	       long valor;
	       int op=-1, cuotas,pasajeros, calles;
	       do{
	          op = Integer.parseInt(JOptionPane.showInputDialog(mensaje.get(0)));
	          if(mensaje.get(2).equals("pasajero") ){
	              pasajero = mensaje.get(3);
	              switch(op){
	                  case 1:
	                      break;
	                  case 2:
	                      break;
	                  case 3:
	                      break;
	                  case 4:
	                      break;
	                  case 5:
	                      break;
	                  case 6:
	                      break; 
	              }
	              
	          }else if(mensaje.get(2).equals("conductor")){
	              conductor = mensaje.get(3);
	              switch(op){
	                  case 1:
	                      break;
	                  case 2:
	                      break;
	                  case 3:
	                      break;
	                  case 4:
	                      break;
	              }
	              
	          }else if(mensaje.get(2).equals("administrador")){
	              switch(op){
	                  case 1:
	                      break;
	                  case 2:
	                      break;
	                  case 3:
	                      break;
	                  case 4:
	                      break;
	              }
	          }
	          
	          
	       }while(op!=0  && ProxyMenu.UnicaInstancia().getFacade().verificarCodigo(mensaje.get(3), Long.parseLong(mensaje.get(1))));
	   }

	}



package Package;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int pasajeros, op = -1;
	        String nombre, correo, contraseña, tipo, salida, hora, conductor, pasajero;
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
	                        contraseña = JOptionPane.showInputDialog("escriba una constraseña");
	                        int t= Integer.parseInt(JOptionPane.showInputDialog("1. administrador\n2.pasajero\n3.conductor"));
	                        switch(t){
	                            case 1: tipo = "administrador"; break;
	                            case 2: tipo = "pasajero"; break;
	                            case 3: tipo = "conductor"; break;
	                            default: tipo = null; break;
	                        }
	                        ProxyMenu.UnicaInstancia().registrarUsuario(tipo, nombre, correo, contraseña);
	                        break;
	                    case 2:
	                        correo= JOptionPane.showInputDialog("ingrese su correo");
	                        contraseña = JOptionPane.showInputDialog("ingrese su contraseña");
	                        datos= ProxyMenu.UnicaInstancia().acceder(correo, contraseña);
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

	}


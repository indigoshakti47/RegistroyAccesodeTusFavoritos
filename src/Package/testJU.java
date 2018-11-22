package Package;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testJU {

	@Test
	void testRegistro() {
		try {
			ProxyMenu.UnicaInstancia().registrarUsuario("pasajero", "Danny Barriga", "carlosbarba@unisabana.edu.co", "1234", "4321", "m", "4/4/98", "");
			Usuario u = ProxyMenu.UnicaInstancia().buscar("carlosbarba@unisabana.edu.co");
			assertTrue(u instanceof Pasajero && u.getNombre().equals("Danny Barriga"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void  testVerificacion() {
		try {
			ProxyMenu.UnicaInstancia().registrarUsuario("pasajero", "Danny Barriga", "carlosbarba@unisabana.edu.co", "1234", "4321", "m", "4/4/98", "");
			int cod = ProxyMenu.UnicaInstancia().getFacade().getValidaciones().get(ProxyMenu.UnicaInstancia().getFacade().getValidaciones().size() - 1).getCodigo();
			ProxyMenu.UnicaInstancia().getFacade().validarCorreo("carlosbarba@unisabana.edu.co", cod);
			assertTrue(ProxyMenu.UnicaInstancia().getFacade().buscarUsuario("carlosbarba@unisabana.edu.co").isValido());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testIniciarSesion() {
		try {
			ProxyMenu.UnicaInstancia().registrarUsuario("pasajero", "Danny Barriga", "carlosbarba@unisabana.edu.co", "1234", "4321", "m", "4/4/98", "");
			ArrayList datos =ProxyMenu.UnicaInstancia().acceder("carlosbarba@unisabana.edu.co", "1234");
			assertTrue(datos != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testEliminar() {
			boolean existe = false, noExiste = false;
		try {
			ProxyMenu.UnicaInstancia().registrarUsuario("pasajero", "Danny Barriga", "carlosbarba@unisabana.edu.co", "1234", "4321", "m", "4/4/98", "");
			existe = ProxyMenu.UnicaInstancia().buscar("carlosbarba@unisabana.edu.co") != null;
			ProxyMenu.UnicaInstancia().getFacade().eliminarUsuario("carlosbarba@unisabana.edu.co");
			ProxyMenu.UnicaInstancia().getFacade().buscarUsuario("carlosbarba@unisabana.edu.co");
			
			
			
		} catch (Exception e) {
			if(e.toString().contains("Usuario no encontrado")) {
				noExiste = true;
			}
		}
		
		assertTrue(existe && noExiste);
		
	}
	
	

}

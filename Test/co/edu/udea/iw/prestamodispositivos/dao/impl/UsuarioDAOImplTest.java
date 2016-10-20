/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import co.edu.udea.iw.prestamodispositivos.dao.UsuarioDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Rol;
import co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento;
import co.edu.udea.iw.prestamodispositivos.modelo.Usuario;

/**
 * Clase para realizar pruebas unitarias que validen el correcto funcionamiento de la clase UsuarioDAOImpl
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDAOImplTest {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Test
	public void test4ObtenerTodos() {
		List<Usuario> resultado = null;
		try {
			resultado = usuarioDAO.obtenerTodos();
			assertTrue(resultado.size() > 0);
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test1guardar() {
		Usuario resultado = new Usuario("julanito", new Rol(2, "Usuario"), 
				new Tipodocumento(2, "Tarjeta de Identidad"), "220232302",
				"julanito de tal", "de tales y pascuales", 
				"julanito@pascuales.com", "julanito");
		try {
			usuarioDAO.guardar(resultado);
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test3ObtenerRolPorID() {
		Usuario resultado = null;
		try {
			resultado = usuarioDAO.obtenerPorId("julanito");
			assertTrue(resultado!= null);
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test2Actualizar() {
		Usuario resultado = null;
		try {
			resultado = new Usuario("julanito", new Rol(2, "Usuario"), 
					new Tipodocumento(2, "Tarjeta de Identidad"), "5000000",
					"julanito de tal", "de nada", 
					"julanito@pascuales.com", "julanito");
			usuarioDAO.actualizar(resultado);
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}

}

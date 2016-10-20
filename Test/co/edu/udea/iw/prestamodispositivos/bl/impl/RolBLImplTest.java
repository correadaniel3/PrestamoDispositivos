/**
 *
 */
package co.edu.udea.iw.prestamodispositivos.bl.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.prestamodispositivos.bl.RolBL;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Rol;

/**
 * Clase para realizar pruebas unitarias que validen el correcto funcionamiento de la clase RolBLImpl
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RolBLImplTest {
	@Autowired
	RolBL rolBL;
	
	@Test 
	public void test1AñadirRol() {
		try {
			rolBL.guardar(13, "Gerente");
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
 
	@Test
	public void test2ActualizarRol() {
		try {
			rolBL.actualizar(13, "jeje");
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test3ObtenerRolPorID() {
		Rol resultado = null;
		try {
			resultado = rolBL.obtenerPorID(13);
			assertTrue(resultado!= null);
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test 
	public void test4ObtenerTodos() {
		List<Rol> resultado = null;
		try {
			resultado = rolBL.obtenerTodos();
			assertTrue(resultado.size() > 0);
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}

}

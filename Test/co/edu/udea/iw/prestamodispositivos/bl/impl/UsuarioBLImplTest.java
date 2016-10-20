/**
 *
 */
package co.edu.udea.iw.prestamodispositivos.bl.impl;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.prestamodispositivos.bl.UsuarioBL;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Rol;
import co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento;

/**
 * Clase para realizar pruebas unitarias que validen el correcto funcionamiento de la clase UsuarioBLImpl
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioBLImplTest {
	@Autowired
	UsuarioBL dao;
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.UsuarioBLImpl#validarAutentificacion(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void test4ValidarAutentificacion() {
		try {
			assertTrue(dao.validarAutentificacion("nose", "nose"));
		} catch (DAOException e) {
			fail(e.getMessage());
		}
		
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.UsuarioBLImpl#registrar(java.lang.String, co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento, java.lang.String, java.lang.String, java.lang.String, co.edu.udea.iw.prestamodispositivos.modelo.Rol, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test 
	public void test1Registrar() {
		try {
			dao.registrar("20226", new Tipodocumento(1, "manager"), "nose", "nose",
					"nose@nose.com", new Rol(2, "Usuario"), "2313213", "nose", "nose");
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.UsuarioBLImpl#actualizarDatos(java.lang.String, co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento, java.lang.String, java.lang.String, java.lang.String, co.edu.udea.iw.prestamodispositivos.modelo.Rol, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void test2ActualizarDatos() {
		try {
			dao.actualizarDatos("20226", new Tipodocumento(1, "manager"), "nose", "nose",
					"nose@nose.com", new Rol(2, "Usuario"), "2313213", "nose", "nose");
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.UsuarioBLImpl#buscarPorID(java.lang.String)}.
	 */
	@Test
	public void test3BuscarPorID() {
		try {
			dao.buscarPorID("nose");
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
}

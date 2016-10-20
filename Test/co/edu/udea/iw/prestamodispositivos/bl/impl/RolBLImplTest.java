/**
 *
 */
package co.edu.udea.iw.prestamodispositivos.bl.impl;

import static org.junit.Assert.fail;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.prestamodispositivos.bl.RolBL;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;

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
	RolBL dao;
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.RolBLImpl#aï¿½adirRol(java.lang.Integer, java.lang.String)}.
	 */
	@Test 
	public void test1AñadirRol() {
		try {
			dao.guardar(12, "Gerente");
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
 
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.RolBLImpl#actualizarRol(java.lang.Integer, java.lang.String)}.
	 */
	@Test
	public void test2ActualizarRol() {
		try {
			dao.actualizar(12, "jeje");
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}

}

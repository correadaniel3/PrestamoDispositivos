/**
 *
 */
package co.edu.udea.iw.prestamodispositivos.bl.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
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
public class RolBLImplTest {
	@Autowired
	RolBL dao;
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.RolBLImpl#aï¿½adirRol(java.lang.Integer, java.lang.String)}.
	 */
	//@Test 
	public void testAñadirRol() {
		try {
			dao.añadirRol(12, "Gerente");
		} catch (DAOException e) {
			new DAOException(e);
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.RolBLImpl#actualizarRol(java.lang.Integer, java.lang.String)}.
	 */
	@Test
	public void testActualizarRol() {
		try {
			dao.actualizarRol(12, "jeje");
		} catch (DAOException e) {
			new DAOException(e);
		}
	}

}

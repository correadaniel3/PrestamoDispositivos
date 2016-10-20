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

import co.edu.udea.iw.prestamodispositivos.bl.EstadosolicitudBL;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;

/**
 * Clase para realizar pruebas unitarias que validen el correcto funcionamiento de la clase EstadosolicitudBLImpl
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EstadosolicitudBLImplTest {

	@Autowired
	EstadosolicitudBL estadosolicitudBL;
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.EstadosolicitudBLImpl#guardar(int, java.lang.String)}.
	 */
	@Test
	public void test1Guardar() {
		try{
			estadosolicitudBL.guardar(99,"prueba");	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.EstadosolicitudBLImpl#actualizar(int, java.lang.String)}.
	 */
	@Test
	public void test2Actualizar() {
		try{
			estadosolicitudBL.actualizar(99, "pruebaalterado");	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.EstadosolicitudBLImpl#borrar(int)}.
	 */
	@Test
	public void test3Borrar() {
		try{
			estadosolicitudBL.borrar(99);	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}

}

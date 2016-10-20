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

import co.edu.udea.iw.prestamodispositivos.bl.DispositivoBL;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;


/**
 * Clase para realizar pruebas unitarias que validen el correcto funcionamiento de la clase DispositivoBLImpl
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DispositivoBLImplTest {

	@Autowired
	DispositivoBL dao;
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.DispositivoBLImpl#guardar(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, byte[])}.
	 */
	@Test
	public void test1Guardar() {
		try{
			dao.guardar("bayer","2016b","probeta","Probeta grande",4,null);	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}
 
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.DispositivoBLImpl#actualizar(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, byte[])}.
	 */
	@Test
	public void test2Actualizar() {
		try{
			dao.actualizar(1,"bayer","2016b","probeta","Probeta muy grande",4,null);	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.DispositivoBLImpl#borrar(int)}.
	 */
	@Test
	public void test3Borrar() {
		try{
			dao.borrar(1);
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}

}

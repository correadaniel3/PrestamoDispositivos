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

import co.edu.udea.iw.prestamodispositivos.bl.TipodocumentoBL;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;


/**
 * Clase para realizar pruebas unitarias que validen el correcto funcionamiento de la clase TipodocumentoBLImpl
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TipodocumentoBLImplTest {
	
	@Autowired
	TipodocumentoBL dao;

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.TipodocumentoBLImpl#guardar(int, java.lang.String)}.
	 */
	@Test
	public void test1Guardar() {
		try{
			dao.guardar(20,"prueba");	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.TipodocumentoBLImpl#actualizar(int, java.lang.String)}.
	 */
	@Test
	public void test2Actualizar() {
		try{
			dao.actualizar(20, "prueba2");	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.TipodocumentoBLImpl#borrar(int)}.
	 */
	@Test
	public void test3Borrar() {
		try{
			dao.borrar(20);	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}

}

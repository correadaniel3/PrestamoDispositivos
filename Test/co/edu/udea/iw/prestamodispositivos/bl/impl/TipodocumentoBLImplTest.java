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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

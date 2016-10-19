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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

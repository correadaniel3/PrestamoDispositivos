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



import co.edu.udea.iw.prestamodispositivos.dao.TipodocumentoDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TipodocumentoDAOImplTest {
	
	@Autowired
	TipodocumentoDAO dao;
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.TipodocumentoDAOImpl#obtenerTodos()}.
	 */
	@Test
	public void test2ObtenerTodos() {
		List<Tipodocumento> tipo;
		try{
			tipo = dao.obtenerTodos();
			assertTrue(tipo.size()> 0);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
			
		}
	}
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.TipodocumentoDAOImpl#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento)}.
	 */
	@Test
	public void test1Guardar() {
		Tipodocumento tipo= new Tipodocumento(20,"Prueba");
		try{
			dao.guardar(tipo);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.TipodocumentoDAOImpl#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento)}.
	 */
	@Test
	public void test4Actualizar() {
		Tipodocumento tipo= new Tipodocumento(20,"PruebaActualizada");
		try{
			dao.actualizar(tipo);
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.TipodocumentoDAOImpl#obtenerPorId(java.lang.Integer)}.
	 */
	@Test
	public void test3ObtenerPorId() {
		Tipodocumento tipo;
		try{
			tipo = dao.obtenerPorId(20);
			assertTrue(tipo!= null);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
			
		}
	}
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.TipodocumentoDAOImpl#borrar(java.lang.Integer)}.
	 */
	@Test
	public void test5Borrar() {
		try{
			dao.borrar(20);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
			
		}
	}
	
}

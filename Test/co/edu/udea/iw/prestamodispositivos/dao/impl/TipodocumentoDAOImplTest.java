/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import co.edu.udea.iw.prestamodispositivos.dao.TipodocumentoDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class TipodocumentoDAOImplTest {
	
	@Autowired
	TipodocumentoDAO dao;
	

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.TipodocumentoDAOImpl#obtenerTodos()}.
	 */
	@Test
	public void testObtenerTodos() {
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
	public void testGuardar() {
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
	public void testActualizar() {
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
	public void testObtenerPorId() {
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
	public void testBorrar() {
		try{
			dao.borrar(20);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
			
		}
	}
	
}

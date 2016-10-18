/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo;


public class DispositivoDAOImplTest {
	@Autowired
	DispositivoDAO dao;
	 
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.DispositivoDAOImpl#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo)}.
	 */
	@Test
	public void testGuardar() {
		Dispositivo dispositivo= new Dispositivo("marca","modelo","nombre","descripcion",5);
		try{
			dao.guardar(dispositivo);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.DispositivoDAOImpl#obtenerTodos()}.
	 */
	@Test
	public void testObtenerTodos() {
		List<Dispositivo> dispositivo;
		try{
			dispositivo = dao.obtenerTodos();
			assertTrue(dispositivo.size()> 0);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.DispositivoDAOImpl#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo)}.
	 */
	@Test
	public void testActualizar() {
		Dispositivo dispositivo;
		try{
			dispositivo= dao.obtenerPorId(1);
			dispositivo.setMarca("Prueba2");
			dao.actualizar(dispositivo);
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.DispositivoDAOImpl#obtenerPorId(java.lang.Integer)}.
	 */
	@Test
	public void testObtenerPorId() {
		Dispositivo dispositivo;
		try{
			dispositivo = dao.obtenerPorId(1);
			assertTrue(dispositivo!=null);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.DispositivoDAOImpl#borrar(java.lang.Integer)}.
	 */
	@Test
	public void testBorrar() {
		try{
			dao.borrar(1);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
			
		}
	}


}

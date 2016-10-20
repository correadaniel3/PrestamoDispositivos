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

import co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo;


/**
 * Clase para realizar pruebas unitarias que validen el correcto funcionamiento de la clase DispositivoDAOImpl
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DispositivoDAOImplTest {
	@Autowired
	DispositivoDAO dao;
	
	 
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.DispositivoDAOImpl#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo)}.
	 */
	@Test
	public void test1Guardar() {
		Dispositivo dispositivo= new Dispositivo("marca","modelo","nombre","descripcion",5);
		try{
			dao.guardar(dispositivo);	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}
 
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.DispositivoDAOImpl#obtenerTodos()}.
	 */
	@Test
	public void test2ObtenerTodos() {
		List<Dispositivo> dispositivo;
		try{
			dispositivo = dao.obtenerTodos();
			assertTrue(dispositivo.size()> 0);	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.DispositivoDAOImpl#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo)}.
	 */
	@Test
	public void test3Actualizar() {
		Dispositivo dispositivo;
		try{
			dispositivo= dao.obtenerPorId(1);
			dispositivo.setMarca("Prueba2");
			dao.actualizar(dispositivo);
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.DispositivoDAOImpl#obtenerPorId(java.lang.Integer)}.
	 */
	@Test
	public void test4ObtenerPorId() {
		Dispositivo dispositivo;
		try{
			dispositivo = dao.obtenerPorId(1);
			assertTrue(dispositivo!=null);	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.DispositivoDAOImpl#borrar(java.lang.Integer)}.
	 */
	@Test
	public void test5Borrar() {
		try{
			dao.borrar(1);	
		}catch (DAOException e) {
			fail(e.getMessage());
			
		}
	}
	
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.DispositivoDAOImpl#obtener(java.lang.String,java.lang.String,java.lang.String)}.
	 */
	@Test
	public void testObtener() {
		Dispositivo dispositivo;
		try{
			dispositivo = dao.obtener("prueba2","modelo","nombre");
			assertTrue(dispositivo!=null);	
		}catch (DAOException e) {
			fail(e.getMessage());
		}
	}


}

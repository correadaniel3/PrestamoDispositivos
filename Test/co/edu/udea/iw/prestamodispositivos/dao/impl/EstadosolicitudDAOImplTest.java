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

import co.edu.udea.iw.prestamodispositivos.dao.EstadosolicitudDAO;
import co.edu.udea.iw.prestamodispositivos.dao.TipodocumentoDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud;
import co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento;

/**
 * Pruebas unitarias para metodos de la clase EstadosolicitudDAOImpl
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EstadosolicitudDAOImplTest {

	@Autowired
	EstadosolicitudDAO estadosolicitudDAO;
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.EstadosolicitudDAOImpl#obtenerTodos()}.
	 */
	@Test
	public void test2ObtenerTodos() {
		List<Estadosolicitud> estadosolicitud;
		try{
			estadosolicitud = estadosolicitudDAO.obtenerTodos();
			assertTrue(estadosolicitud.size()> 0);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.EstadosolicitudDAOImpl#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud)}.
	 */
	@Test
	public void test1Guardar() {
		Estadosolicitud estadosolicitud= new Estadosolicitud(99,"Test");
		try{
			estadosolicitudDAO.guardar(estadosolicitud);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.EstadosolicitudDAOImpl#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud)}.
	 */
	@Test
	public void test4Actualizar() {
		Estadosolicitud estadosolicitud= new Estadosolicitud(99,"TestAlterado");
		try{
			estadosolicitudDAO.actualizar(estadosolicitud);
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.EstadosolicitudDAOImpl#borrar(java.lang.Integer)}.
	 */
	@Test
	public void test5Borrar() {
		try{
			estadosolicitudDAO.borrar(99);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
			
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.EstadosolicitudDAOImpl#obtenerPorId(java.lang.Integer)}.
	 */
	@Test
	public void test3ObtenerPorId() {
		Estadosolicitud estadosolicitud;
		try{
			estadosolicitud = estadosolicitudDAO.obtenerPorId(99);
			assertTrue(estadosolicitud!= null);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
			
		}
	}
}

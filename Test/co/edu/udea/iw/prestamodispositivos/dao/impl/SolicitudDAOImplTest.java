/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO;
import co.edu.udea.iw.prestamodispositivos.dao.EstadosolicitudDAO;
import co.edu.udea.iw.prestamodispositivos.dao.RolDAO;
import co.edu.udea.iw.prestamodispositivos.dao.SolicitudDAO;
import co.edu.udea.iw.prestamodispositivos.dao.TipodocumentoDAO;
import co.edu.udea.iw.prestamodispositivos.dao.UsuarioDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Solicitud;

/**
 * Pruebas unitarias para metodos de la clase SolicitudDAOImpl
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SolicitudDAOImplTest {

	@Autowired
	SolicitudDAO solicitudDAO;
	@Autowired
	EstadosolicitudDAO estadosolicitudDAO;
	@Autowired
	DispositivoDAO dispositivoDAO;
	@Autowired
	UsuarioDAO usuarioDAO;
	@Autowired
	RolDAO rolDAO;
	@Autowired
	TipodocumentoDAO tipodocumentoDAO;
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.SolicitudDAOImpl#obtenerTodos()}.
	 */
	@Test
	public void test3ObtenerTodos() {
		List<Solicitud> solicitud;
		try{
			solicitud = solicitudDAO.obtenerTodos();
			assertTrue(solicitud.size()> 0);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.SolicitudDAOImpl#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Solicitud)}.
	 */
	@Test
	public void test1Guardar() {
		Date fechafin=new Date();
		try{
			fechafin.setMinutes(fechafin.getMinutes()+1);
			Solicitud solicitud= new Solicitud();
			solicitud.setCantidad(1);
			solicitud.setUsuario(usuarioDAO.obtenerTodos().get(0));
			solicitud.setDispositivo(dispositivoDAO.obtenerTodos().get(0));
			solicitud.setEstadosolicitud(estadosolicitudDAO.obtenerPorId(2));
			solicitud.setFechafin(fechafin);
			solicitud.setFechainicio(new Date());
			solicitud.setFechasolicitud(new Date());
			solicitudDAO.guardar(solicitud);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.SolicitudDAOImpl#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Solicitud)}.
	 */
	@Test
	public void test4Actualizar() {
		try{
			Solicitud solicitud= solicitudDAO.obtenerTodos().get(0);
			solicitud.setEstadosolicitud(estadosolicitudDAO.obtenerPorId(3));
			solicitudDAO.actualizar(solicitud);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.SolicitudDAOImpl#obtenerPorId(java.lang.Integer)}.
	 */
	@Test
	public void test2ObtenerPorId() {
		Solicitud solicitud;
		try{
			solicitud = solicitudDAO.obtenerPorId(solicitudDAO.obtenerTodos().get(0).getId());
			assertTrue(solicitud!= null);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.SolicitudDAOImpl#obtenerPorDispositivo(java.lang.Integer)}.
	 */
	@Test
	public void test5ObtenerPorDispositivo() {
		List<Solicitud> solicitud;
		Date fechafin=new Date(117,01,01);
		Date fechainicio=new Date(115,01,01);
		try{
			solicitud = solicitudDAO.obtenerPorDispositivo(dispositivoDAO.obtenerTodos().get(0).getId(),fechainicio,fechafin);
			assertTrue(solicitud.size()>0);	
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

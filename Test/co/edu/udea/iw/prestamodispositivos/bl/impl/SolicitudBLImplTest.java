/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.prestamodispositivos.bl.SolicitudBL;
import co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO;
import co.edu.udea.iw.prestamodispositivos.dao.EstadosolicitudDAO;
import co.edu.udea.iw.prestamodispositivos.dao.SolicitudDAO;
import co.edu.udea.iw.prestamodispositivos.dao.UsuarioDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;

/**
 * Clase para realizar pruebas unitarias que validen el correcto funcionamiento de la clase SolicitudBLImpl
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SolicitudBLImplTest {

	@Autowired
	DispositivoDAO dispositivoDAO;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Autowired
	SolicitudBL solicitudBL;
	
	@Autowired
	SolicitudDAO solicitudDAO;
	
	@Autowired
	EstadosolicitudDAO estadosolicitudDAO;
	
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.SolicitudBLImpl#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo, co.edu.udea.iw.prestamodispositivos.modelo.Usuario, int, java.util.Date, java.util.Date)}.
	 */
	@Test
	public void test1Guardar() {
		try{
			solicitudBL.guardar(dispositivoDAO.obtenerTodos().get(0),usuarioDAO.obtenerTodos().get(0),1,new Date(), new Date());
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.bl.impl.SolicitudBLImpl#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo, co.edu.udea.iw.prestamodispositivos.modelo.Usuario, int, java.util.Date, java.util.Date, co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud)}.
	 */
	@Test
	public void test2Actualizar() {
		try{
			solicitudBL.actualizar(solicitudDAO.obtenerTodos().get(0).getId(),dispositivoDAO.obtenerTodos().get(0),usuarioDAO.obtenerTodos().get(0),1,new Date(), new Date(),estadosolicitudDAO.obtenerPorId(3));
		}catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

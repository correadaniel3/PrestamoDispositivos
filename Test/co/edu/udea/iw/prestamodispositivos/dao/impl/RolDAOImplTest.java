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
import co.edu.udea.iw.prestamodispositivos.modelo.Rol;
import co.edu.udea.iw.prestamodispositivos.dao.RolDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
/**
 * Clase para realizar pruebas unitarias que validen el correcto funcionamiento de la clase RolDAOImpl
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class RolDAOImplTest {
	@Autowired
	RolDAO dao;
	
	@Test 
	public void testObtenerTodos() {
		List<Rol> resultado = null;
		try {
			resultado = dao.obtenerTodos();
			System.out.println(resultado.toString());
			assertTrue(resultado.size() > 0);
		} catch (DAOException e) {
			new DAOException(e);
		}
	}
	
	@Test
	public void testguardar() {
		Rol resultado = new Rol(14212, "Usuario frecuente");
		try {
			dao.guardar(resultado);
		} catch (DAOException e) {
			new DAOException(e);
		}
	}
	@Test
	public void testObtenerRolPorID() {
		Rol resultado = null;
		try {
			resultado = dao.obtenerPorId(120);
			assertTrue(resultado!= null);
		} catch (DAOException e) {
			new DAOException(e);
		}
	}
	@Test
	public void testEditCity() {
		Rol resultado = new Rol();
		try {
			resultado.setId(1421);
			resultado.setNombre("LOLO");
			dao.actualizar(resultado);
		} catch (DAOException e) {
			new DAOException(e);
		}
	}
}

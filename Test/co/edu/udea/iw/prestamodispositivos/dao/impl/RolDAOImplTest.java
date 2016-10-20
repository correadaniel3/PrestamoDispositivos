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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RolDAOImplTest {
	@Autowired
	RolDAO rolDAO;
	
	@Test 
	public void test4ObtenerTodos() {
		List<Rol> resultado = null;
		try {
			resultado = rolDAO.obtenerTodos();
			assertTrue(resultado.size() > 0);
		} catch (DAOException e) {
			fail(e.getMessage());;
		}
	}
	
	@Test
	public void test1guardar() {
		Rol resultado = new Rol(10, "Usuario frecuente");
		try {
			rolDAO.guardar(resultado);
		} catch (DAOException e) {
			fail(e.getMessage());
		}
	}
	@Test
	public void test3ObtenerRolPorID() {
		Rol resultado = null;
		try {
			resultado = rolDAO.obtenerPorId(14212);
			assertTrue(resultado!= null);
		} catch (DAOException e) {
			fail(e.getMessage());;
		}
	}
	@Test
	public void test2actualizar() {
		Rol resultado = new Rol();
		try {
			resultado.setId(12);
			resultado.setNombre("LOLOlolo");
			rolDAO.actualizar(resultado);
		} catch (DAOException e) {
			fail(e.getMessage());;
		}
	}
}

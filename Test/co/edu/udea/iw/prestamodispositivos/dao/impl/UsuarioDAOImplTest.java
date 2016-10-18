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
import co.edu.udea.iw.prestamodispositivos.modelo.Usuario;
import co.edu.udea.iw.prestamodispositivos.dao.RolDAO;
import co.edu.udea.iw.prestamodispositivos.dao.UsuarioDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class UsuarioDAOImplTest {
	@Autowired
	RolDAO dao;
	/**
	 * Test method for {@link co.edu.udea.iw.prestamodispositivos.dao.impl.UsuarioDAOImpl#obtenerTodos()}.
	 */
	@Test
	public void testObtenerTodos() {
		Rol rol = new Rol(120, "Usuario frecuente");
		try {
			dao.guardar(rol);
		} catch (DAOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}

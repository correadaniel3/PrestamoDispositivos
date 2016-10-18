/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao;

import java.util.List;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Usuario;

/**
 * Clase data access object para manejo de operaciones basicas en la base de datos de la tabla Usuario
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface UsuarioDAO {
	/**
	 * 
	 * @return lista de usuarios en la base de datos
	 * @throws DAOException
	 */
	public List<Usuario> obtenerTodos () throws DAOException;
	
	/**
	 * Guarda un nuevo usuario en la base de datos
	 * @param usuario que se va insertar en la base de datos
	 * @throws DAOException
	 */
	public void guardar (Usuario usuario) throws DAOException;
	
	/**
	 * Actualizar un usuario que existe en la base de datos
	 * @param usuario que se va a actualizar en la base de datos
	 * @throws DAOException
	 */
	public void actualizar (Usuario usuario) throws DAOException;
	
	/**
	 * 
	 * @param nombreusuario del  usuario que se desea buscar y obtener de la base de datos
	 * @return el usuario buscado en la base de datos
	 * @throws DAOException
	 */
	public Usuario obtenerPorId (String nombreusuario) throws DAOException;
}

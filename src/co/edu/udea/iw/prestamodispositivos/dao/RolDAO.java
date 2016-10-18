/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao;

import java.util.List;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Rol;

/**
 * Clase data access object para manejo de operaciones basicas en la base de datos de la tabla rol
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface RolDAO {
	
	/**
	 * 
	 * @return lista de roles en la base de datos
	 * @throws DAOException
	 */
	public List<Rol> obtenerTodos () throws DAOException;
	
	/**
	 * 
	 * @param rol que se va insertar en la base de datos
	 * @throws DAOException
	 */
	public void guardar (Rol rol) throws DAOException;
	
	/**
	 * 
	 * @param rol que se va a actualizar en la base de datos
	 * @throws DAOException
	 */
	public void actualizar (Rol rol) throws DAOException;
	
	/**
	 * 
	 * @param id del rol que se desea eliminar en la base de datos 
	 * @throws DAOException
	 */
	public void borrar (int id) throws DAOException;
	
	/**
	 * 
	 * @param id del rol que se desea buscar y obtener de la base de datos
	 * @return el rol buscado en la base de datos
	 * @throws DAOException
	 */
	public Rol obtenerPorId (int id) throws DAOException;
}

/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl;

import java.util.List;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Rol;

/**
 * Interfaz que expone los métodos de la logica del negocio para la tabla rol
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface RolBL {
	/**
	 * Inserta un nuevo rol en la base de datos
	 * @param codigo
	 * @param nombre
	 * @throws DAOException
	 */
	public void guardar(Integer codigo, String nombre) throws DAOException;
	/**
	 * Actualiza un rol que exista previamente
	 * @param codigo
	 * @param nombre
	 * @throws DAOException
	 */
	public void actualizar(Integer codigo, String nombre) throws DAOException;
	/**
	 * Retorna la lista de roles disponibles en la BD
	 * @return lista de roles
	 * @throws DAOException en caso que no existan roles en la BD
	 */
	public List<Rol> obtenerTodos() throws DAOException;
	/**
	 * Obtiene un rol por sus respectivo ID, en caso que exista
	 * @param id
	 * @return Rol asociado al parametro id
	 * @throws DAOException en caso que no existe se lanzara la respectiva exception
	 */
	public Rol obtenerPorID(int id) throws DAOException;
}

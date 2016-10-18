/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao;

import java.util.List;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento;

/**
 * Clase data access object para manejo de operaciones básicas en la base de datos de la tabla tipodocumento
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface TipodocumentoDAO {
	
	/**
	 * 
	 * @return lista de tipos de documento en la base de datos
	 * @throws DAOException
	 */
	public List<Tipodocumento> obtenerTodos () throws DAOException;
	
	/**
	 * 
	 * @param tipodocumento que se va insertar en la base de datos
	 * @throws DAOException
	 */
	public void guardar (Tipodocumento tipodocumento) throws DAOException;
	
	/**
	 * 
	 * @param tipodocumento que se va a actualizar en la base de datos
	 * @throws DAOException
	 */
	public void actualizar (Tipodocumento tipodocumento) throws DAOException;
	
	/**
	 * 
	 * @param id del tipo de documento que se desea eliminar en la base de datos 
	 * @throws DAOException
	 */
	public void borrar (int id) throws DAOException;
	
	/**
	 * 
	 * @param id del tipo de documento que se desea buscar y obtener de la base de datos
	 * @return el tipo de documento buscado en la base de datos
	 * @throws DAOException
	 */
	public Tipodocumento obtenerPorId (int id) throws DAOException;
}

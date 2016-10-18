/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao;

import java.util.List;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud;

/**
 * Clase data access object para manejo de operaciones basicas en la base de datos de la tabla estadosolicitud
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface EstadosolicitudDAO {
	/**
	 * 
	 * @return lista de los estado de solicitud en la base de datos
	 * @throws DAOException
	 */
	public List<Estadosolicitud> obtenerTodos () throws DAOException;
	
	/**
	 * 
	 * @param estadosolicitud que se va insertar en la base de datos
	 * @throws DAOException
	 */
	public void guardar (Estadosolicitud estadosolicitud) throws DAOException;
	
	/**
	 * 
	 * @param estadosolicitud que se va a actualizar en la base de datos
	 * @throws DAOException
	 */
	public void actualizar (Estadosolicitud estadosolicitud) throws DAOException;
	
	/**
	 * 
	 * @param id del estado de solicitud que se desea eliminar en la base de datos 
	 * @throws DAOException
	 */
	public void borrar (Integer id) throws DAOException;
	
	/**
	 * 
	 * @param id del estado de solicitud que se desea buscar y obtener de la base de datos
	 * @return la solicitud buscada en la base de datos
	 * @throws DAOException
	 */
	public Estadosolicitud obtenerPorId (Integer id) throws DAOException;
}

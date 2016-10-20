/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Solicitud;

/**
 * Clase data access object para manejo de operaciones basicas en la base de datos de la tabla solicitud
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface SolicitudDAO {
	/**
	 * 
	 * @return lista de las solicitudes en la base de datos
	 * @throws DAOException
	 */
	public List<Solicitud> obtenerTodos () throws DAOException;
	
	/**
	 * 
	 * @param solicitud que se va insertar en la base de datos
	 * @throws DAOException
	 */
	public void guardar (Solicitud solicitud) throws DAOException;
	
	/**
	 * 
	 * @param solicitud que se va a actualizar en la base de datos
	 * @throws DAOException
	 */
	public void actualizar (Solicitud solicitud) throws DAOException;
	
	/**
	 * 
	 * @param id de la solicitud que se desea buscar y obtener de la base de datos
	 * @return la solicitud buscada en la base de datos
	 * @throws DAOException
	 */
	public Solicitud obtenerPorId (Integer id) throws DAOException;
	
	/**
	 * 
	 * @param id del dispositivo del cual se desea obtener las solicitudes
	 * @param fechainicio de la solicitud
	 * @param fechafin de la solicitud
	 * @return lista de solicitudes asociadas a un dispositivo 
	 * @throws DAOException
	 */
	public List<Solicitud> obtenerPorDispositivo (Integer id, Date fechainicio, Date fechafin) throws DAOException;
}

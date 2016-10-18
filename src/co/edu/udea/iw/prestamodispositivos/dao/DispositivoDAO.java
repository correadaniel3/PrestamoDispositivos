/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao;

import java.util.List;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo;

/**
 * Clase data access object para manejo de operaciones básicas en la base de datos de la tabla dispositivo
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface DispositivoDAO {
	
	/**
	 * 
	 * @return lista de dispositivos en la base de datos
	 * @throws DAOException
	 */
	public List<Dispositivo> obtenerTodos () throws DAOException;
	
	/**
	 * 
	 * @param dispositivo que se va insertar en la base de datos
	 * @throws DAOException
	 */
	public void guardar (Dispositivo dispositivo) throws DAOException;
	
	/**
	 * 
	 * @param dispositivo que se va a actualizar en la base de datos
	 * @throws DAOException
	 */
	public void actualizar (Dispositivo dispositivo) throws DAOException;
	
	/**
	 * 
	 * @param id del dispositivo que se desea eliminar en la base de datos 
	 * @throws DAOException
	 */
	public void borrar (Integer id) throws DAOException;
	
	/**
	 * 
	 * @param id del dispositivo que se desea buscar y obtener de la base de datos
	 * @return el dispositivo buscado en la base de datos
	 * @throws DAOException
	 */
	public Dispositivo obtenerPorId (Integer id) throws DAOException;
}

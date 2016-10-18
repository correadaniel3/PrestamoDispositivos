/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;

/**
 * Interfaz que expone los métodos de la logica del negocio para la tabla estadosolicitud
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface EstadosolicitudBL {

	/**
	 * Insertar un estado de solicitud en la base de datos
	 * @param id de estado de solicitud que se va a insertar
	 * @param estado para asignar a las solicitudes
	 * @throws DAOException
	 */
	public void guardar(int id, String estado) throws DAOException;
	
	/**
	 * Actualizar un estado de solicitud en la base de datos
	 * @param id de estado de solicitud que se va a actualizar
	 * @param estado para asignar a las solicitudes
	 * @throws DAOException
	 */
	public void actualizar(int id, String estado) throws DAOException;
	
	/**
	 * Eliminar un estado de solicitud en la base de datos
	 * @param id de estado de solicitud que se va a eliminar
	 * @throws DAOException
	 */
	public void borrar(int id) throws DAOException;
}

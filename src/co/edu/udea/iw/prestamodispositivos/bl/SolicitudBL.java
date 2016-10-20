/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl;

import java.util.Date;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo;
import co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud;
import co.edu.udea.iw.prestamodispositivos.modelo.Usuario;

/**
 * Interfaz que expone los métodos de la logica del negocio para la tabla solicitud
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface SolicitudBL {
	
	/**
	 * Metodo de la logica del negocio que valida la creacion de una solicitud
	 * @param dispositivo asociado a la solicitud
	 * @param usuario asociado a la solicitud
	 * @param cantidad de dispositivos solicitados
	 * @param fechainicio del prestamo
	 * @param fechafin del prestamo
	 * @throws DAOException
	 */
	public void guardar(Dispositivo dispositivo, Usuario usuario, int cantidad, Date fechainicio, Date fechafin) throws DAOException;
	
	/**
	 * Metodo de la logica del negocio que valida la actualizacion de una solicitud
	 * @param id asociado a la solicitud
	 * @param dispositivo asociado a la solicitud
	 * @param usuario asociado a la solicitud
	 * @param cantidad de dispositivos solicitados
	 * @param fechainicio del prestamo
	 * @param fechafin del prestamo
	 * @param estadosolicitud para actualizar la solicitud
	 * @throws DAOException
	 */
	public void actualizar(Integer id, Dispositivo dispositivo, Usuario usuario, int cantidad, Date fechainicio, Date fechafin, Estadosolicitud estadosolicitud) throws DAOException;
}

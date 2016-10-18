package co.edu.udea.iw.prestamodispositivos.exception;

import org.apache.log4j.Logger;

/**
 * Clase para el manejo de excepciones de los DAOs
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class DAOException extends Exception {
	
	Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * @param message Mensaje para retornar en la excepción
	 * @param cause Nombre o tipo de excepción
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
		log.error(message);
	}


	/**
	 * @param cause Nombre o tipo de excepción
	 */
	public DAOException(Throwable cause) {
		super(cause);
		log.error(cause.getMessage());
	}

	/**
	 * 
	 * @param error
	 */
	public DAOException(String error) {
		log.error(error);
	}
}

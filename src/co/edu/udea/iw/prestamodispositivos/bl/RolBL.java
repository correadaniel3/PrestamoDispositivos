/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;

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
	public void añadirRol(Integer codigo, String nombre) throws DAOException;
	/**
	 * Actualiza un rol que exista previamente
	 * @param codigo
	 * @param nombre
	 * @throws DAOException
	 */
	public void actualizarRol(Integer codigo, String nombre) throws DAOException;
}

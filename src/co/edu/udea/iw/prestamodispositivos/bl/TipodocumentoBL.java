/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;

/**
 * Interfaz que expone los métodos de la logica del negocio para la tabla Tipodocumento
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface TipodocumentoBL {
	/**
	 * Comprobar y guardar un nuevo tipo de documento en la base de datos
	 * @param id identificador del tipo de documento
	 * @param tipo del documento
	 * @throws DAOException
	 */
	public void guardar(int id, String tipo) throws DAOException;
	
	/**
	 * Actualizar un tipo de documento en la base de datos
	 * @param id del tipo de documento a actualizar
	 * @param tipo de documento actualizado
	 * @throws DAOException
	 */
	public void actualizar (int id, String tipo) throws DAOException;
	
	
	/**
	 * Borrar un tipo de documentos de la base de datos
	 * @param id del tipo de documento a borrar
	 * @throws DAOException
	 */
	public void borrar(int id) throws DAOException;
	
	
}

/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl;

import java.util.List;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento;

/**
 * Interfaz que expone los m�todos de la logica del negocio para la tabla Tipodocumento
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
	
	/**
	 * Obtiene un Tipo de documento por su respectivo ID, en caso que exista
	 * @param id
	 * @return Tipodocumento asociado al parametro id
	 * @throws DAOException en caso que no existe se lanzara la respectiva exception
	 */
	public Tipodocumento obtenerPorID(int id) throws DAOException;
	
	/**
	 * Metodo para obtener todos los tipos de documento en la base de datos
	 * @return lista con todos los tipos de documento
	 * @throws DAOException
	 */
	public List<Tipodocumento> obtenerTodos() throws DAOException;
	
	
}

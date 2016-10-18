/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;

/**
 * Interfaz que expone los métodos de la logica del negocio para la tabla dispositivo
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface DispositivoBL {
	
	/**
	 * Comprobar y guardar un nuevo dispositivo en la base de datos
	 * @param marca
	 * @param modelo
	 * @param nombre
	 * @param descripcion
	 * @param cantidad
	 * @param imagen
	 * @throws DAOException
	 */
	public void guardar(String marca, String modelo, String nombre, String descripcion, int cantidad, byte[] imagen) throws DAOException;
	
	/**
	 * Actualizar un dispositivo en la base de datos
	 * @param id
	 * @param marca
	 * @param modelo
	 * @param nombre
	 * @param descripcion
	 * @param cantidad
	 * @param imagen
	 * @throws DAOException
	 */
	public void actualizar (Integer id, String marca, String modelo, String nombre, String descripcion, int cantidad, byte[] imagen) throws DAOException;
	
	
	/**
	 * Borrar un dispositivo de la base de datos
	 * @param id del tipo de documento a borrar
	 * @throws DAOException
	 */
	public void borrar(int id) throws DAOException;

}

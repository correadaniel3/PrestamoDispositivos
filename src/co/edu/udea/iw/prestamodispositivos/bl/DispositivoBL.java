/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl;

import java.util.List;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo;

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
	public void actualizar (Integer id, String marca, String modelo, String nombre, 
			String descripcion, int cantidad, byte[] imagen) throws DAOException;
	
	
	/**
	 * Borrar un dispositivo de la base de datos
	 * @param id del tipo de documento a borrar
	 * @throws DAOException
	 */
	public void borrar(int id) throws DAOException;
	
	/**
	 * Metodo para obtener todos los dispositivos de la base de datos
	 * @return lista de dispositivos en la base de datos
	 * @throws DAOException
	 */
	public List<Dispositivo> obtenerTodos () throws DAOException;
	
	/**
	 * Metodo para obtener un dispositivo
	 * @param id del dispositivo que se desea buscar y obtener de la base de datos
	 * @return el dispositivo buscado en la base de datos
	 * @throws DAOException
	 */
	public Dispositivo obtenerPorId (Integer id) throws DAOException;

}

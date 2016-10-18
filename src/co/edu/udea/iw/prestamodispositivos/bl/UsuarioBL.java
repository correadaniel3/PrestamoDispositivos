/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl;

import org.hibernate.exception.DataException;

import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Rol;
import co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento;

/**
 * Interfaz que expone los métodos de la logica del negocio para la tabla usuario
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public interface UsuarioBL {
	/**
	 * Metodo para verificar la validez de los datos de ingreso a la plataforma
	 * @param nombreusuario nickname asociado a un usuario específico
	 * @param contraseña asociado al usuario que corresponda al nickname
	 * @return true si el ingreso de los datos es correcto
	 * @throws DAOException
	 */
	public Boolean validarAutentificacion(String nombreusuario, String contrasena ) throws DAOException;
	/**
	 * Comprobar y guardar un nuevo usuario en la base de datos
	 * @param documento identificación del usuario
	 * @param tipodocumento tipo de documento asociado al usuario
	 * @param nombres
	 * @param apellidos
	 * @param correoelectronico
	 * @param rol tipo de rol que posee el usuario
	 * @param telefono
	 * @param contrasena
	 * @param nombreusuario nickname unico con el que se identificara al usuario
	 * @throws DAOException
	 */
	public void registrar(String documento, Tipodocumento tipodocumento, String nombres, 
			String apellidos, String correoelectronico, Rol rol, String telefono, String contrasena, 
			String nombreusuario)throws DAOException;
	/**
	 * Actualizar los datos cambiados de un usuario
	 * @param documento
	 * @param tipodocumento
	 * @param nombres
	 * @param apellidos
	 * @param correoelectronico
	 * @param rol
	 * @param telefono
	 * @param contrasena
	 * @param nombreusuario usuario a modificar, este campo no es modificable
	 * @throws DataException
	 */
	public void actualizarDatos(String documento, Tipodocumento tipodocumento, String nombres, 
			String apellidos, String correoelectronico, Rol rol, String telefono, String contrasena,
			String nombreusuario)throws DAOException;
}

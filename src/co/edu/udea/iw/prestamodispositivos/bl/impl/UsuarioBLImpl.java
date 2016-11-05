/**
 *
 */
package co.edu.udea.iw.prestamodispositivos.bl.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.prestamodispositivos.bl.UsuarioBL;
import co.edu.udea.iw.prestamodispositivos.dao.RolDAO;
import co.edu.udea.iw.prestamodispositivos.dao.UsuarioDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Rol;
import co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento;
import co.edu.udea.iw.prestamodispositivos.modelo.Usuario;
import co.edu.udea.iw.prestamodispositivos.util.encode.Cifrar;
import co.edu.udea.iw.prestamodispositivos.util.validations.Validaciones;

/**
 * Clase que implementa los metodos de la logica del negocio para la tabla usuario de la base de datos usuario
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@Transactional
public class UsuarioBLImpl implements UsuarioBL {

	private UsuarioDAO usuarioDAO;
	private RolDAO rolDAO;

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.UsuarioBL#validarAutentificacion(java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean autenticar(String nombreusuario, String contrasena) throws DAOException {
		Usuario usuario = null;
		if(Validaciones.isTextoVacio(nombreusuario)){
			throw new DAOException("El nombre de usuario es incorrecto");
		}
		if(Validaciones.isTextoVacio(contrasena)){
			throw new DAOException("La contraseï¿½a es incorrecta");
		}
		usuario = usuarioDAO.obtenerPorId(nombreusuario);
		if(usuario == null){
			throw new DAOException("El Usuario o la contraseï¿½a ingresada son incorrectas");
		}
		Cifrar cifrado=new Cifrar();
		contrasena=cifrado.encrypt(contrasena);
		if(!usuario.getContrasena().equals(contrasena)){
			throw new DAOException("El Usuario o la contraseï¿½a ingresada son incorrectas");
		}
		return Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.UsuarioBL#registrar(java.lang.String, co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento, java.lang.String, java.lang.String, java.lang.String, co.edu.udea.iw.prestamodispositivos.modelo.Rol, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void registrar(String documento, Tipodocumento tipodocumento, String nombres, String apellidos,
			String correoelectronico, Rol rol, String telefono, String contrasena, String nombreusuario)
			throws DAOException {
		Usuario usuario = null;
		if(Validaciones.isTextoVacio(documento)){
			throw new DAOException("El documento del usuario es incorrecto");
		}
		if(tipodocumento == null){
			throw new DAOException("El tipo de documento del usuario es incorrecto");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new DAOException("Los nombres del usuarios son incorrectos");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			throw new DAOException("Los apellidos del usuarios son incorrectos");
		}
		if(Validaciones.isTextoVacio(correoelectronico)){
			throw new DAOException("El correo electronico del usuario es incorrecto");
		}
		if(!Validaciones.isEmail(correoelectronico)){
			throw new DAOException("El correo electronico del usuario es incorrecto");
		}
		if(rol == null){
			throw new DAOException("El rol de usuario es incorrecto");
		}
		if(Validaciones.isTextoVacio(contrasena)){
			throw new DAOException("La contraseï¿½a es incorrecta");
		}
		if(Validaciones.isTextoVacio(nombreusuario)){
			throw new DAOException("El nombre de usuario es incorrecto");
		}
		if(usuarioDAO.obtenerPorId(nombreusuario.trim().toLowerCase()) != null){
			throw new DAOException("El nombre de usuario no esta disponible");
		}
		Cifrar cifrado=new Cifrar();
		contrasena=cifrado.encrypt(contrasena);
		usuario = new Usuario(nombreusuario, rol, tipodocumento, documento,
				nombres, apellidos, correoelectronico, contrasena);
		usuarioDAO.guardar(usuario);
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.UsuarioBL#actualizarDatos(java.lang.String, co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento, java.lang.String, java.lang.String, java.lang.String, co.edu.udea.iw.prestamodispositivos.modelo.Rol, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void actualizar(String documento, Tipodocumento tipodocumento, String nombres, String apellidos,
			String correoelectronico, Rol rol, String telefono, String contrasena, String nombreusuario) throws DAOException{
		Usuario usuario = null;
		if(Validaciones.isTextoVacio(documento)){
			throw new DAOException("El documento del usuario es incorrecto");
		}
		if(tipodocumento == null){
			throw new DAOException("El tipo de documento del usuario es incorrecto");
		}
		if(Validaciones.isTextoVacio(nombres)){
			throw new DAOException("Los nombres del usuarios son incorrectos");
		}
		if(Validaciones.isTextoVacio(apellidos)){
			throw new DAOException("Los apellidos del usuarios son incorrectos");
		}
		if(Validaciones.isTextoVacio(correoelectronico)){
			throw new DAOException("El correo electronico del usuario es incorrecto");
		}
		if(!Validaciones.isEmail(correoelectronico)){
			throw new DAOException("El correo electronico del usuario es incorrecto");
		}
		if(rol == null){
			throw new DAOException("El rol de usuario es incorrecto");
		}
		if(rolDAO.obtenerPorId(rol.getId()) == null){
			throw new DAOException("El rol de usuario no existe");
		}
		if(Validaciones.isTextoVacio(contrasena)){
			throw new DAOException("La contraseña es incorrecta");
		}
		if(Validaciones.isTextoVacio(nombreusuario)){
			throw new DAOException("El nombre de usuario es incorrecto");
		}
		Cifrar cifrado=new Cifrar();
		contrasena=cifrado.encrypt(contrasena);
		usuario = new Usuario(nombreusuario, rol, tipodocumento, documento,
				nombres, apellidos, correoelectronico, contrasena);
		usuarioDAO.actualizar(usuario);
	}
	
	@Override
	public Usuario buscarPorID(String nombreusuario) throws DAOException {
		Usuario usuario = null;
		if (Validaciones.isTextoVacio(nombreusuario)) {
			throw new DAOException("El nombre de usuario es incorrecto");
		}
		usuario = usuarioDAO.obtenerPorId(nombreusuario);
		if(usuario == null){
			throw new DAOException("No existe el usuario con el nombre "+nombreusuario);
		}
		return usuario;
	}

	@Override
	public List<Usuario> obtenerTodos() throws DAOException {
		List<Usuario> resultado = null;
		resultado = usuarioDAO.obtenerTodos();
		if (resultado == null) {
			throw new DAOException("Actualmente no existen usuarios creados.");
		}
		return resultado;
	}
	
	public RolDAO getRolDAO() {
		return rolDAO;
	}

	public void setRolDAO(RolDAO rolDAO) {
		this.rolDAO = rolDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}

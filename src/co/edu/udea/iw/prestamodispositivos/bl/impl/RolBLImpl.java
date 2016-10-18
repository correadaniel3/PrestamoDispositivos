/**
 *
 */
package co.edu.udea.iw.prestamodispositivos.bl.impl;

import java.util.List;

import co.edu.udea.iw.prestamodispositivos.bl.RolBL;
import co.edu.udea.iw.prestamodispositivos.dao.RolDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Rol;
import co.edu.udea.iw.prestamodispositivos.util.validations.Validaciones;

/**
 * Clase que implementa los mï¿½todos de la logica del negocio para la tabla de la base de datos Rol
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class RolBLImpl implements RolBL {
	private RolDAO rolDAO;
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.RolBL#aï¿½adirRol(java.lang.Integer, java.lang.String)
	 */
	@Override
	public void añadirRol(Integer codigo, String nombre) throws DAOException {
		if(codigo == null){
			throw new DAOException("EL codigo del rol es erroneo");
		}
		if(Validaciones.isTextoVacio(nombre)){
			throw new DAOException("EL nombre del rol es erroneo");
		}
		List<Rol> resultado = rolDAO.obtenerTodos();
		String nombreAux = nombre.trim().toLowerCase(); 
		for (Rol rol : resultado) {
			if (rol.getNombre().trim().toLowerCase().equalsIgnoreCase(nombreAux)) {
				throw new DAOException("EL nombre del rol ya existe");
			}
		}
		Rol rol = new Rol(codigo, nombre);
		try {
			rolDAO.guardar(rol);
		} catch (DAOException e) {
			throw new DAOException(e);
		}
	}
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.RolBL#actualizarRol(java.lang.Integer, java.lang.String)
	 */
	@Override
	public void actualizarRol(Integer codigo, String nombre) throws DAOException {
		if(codigo == null){
			throw new DAOException("EL codigo del rol es erroneo");
		}
		if(Validaciones.isTextoVacio(nombre)){
			throw new DAOException("EL nombre del rol es erroneo");
		}
		if(rolDAO.obtenerPorId(codigo) == null){
			throw new DAOException("EL rol a modificar no existe");
		}
		Rol rol = new Rol(codigo, nombre);
		rolDAO.actualizar(rol);
	}
	
	public RolDAO getRolDAO() {
		return rolDAO;
	}

	public void setRolDAO(RolDAO rolDAO) {
		this.rolDAO = rolDAO;
	}
}

/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.prestamodispositivos.bl.EstadosolicitudBL;
import co.edu.udea.iw.prestamodispositivos.dao.EstadosolicitudDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud;
import co.edu.udea.iw.prestamodispositivos.util.validations.Validaciones;

/**
 * Clase que implementa los metodos de la logica del negocio para la tabla estadosolicitud de la base de datos
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@Transactional
public class EstadosolicitudBLImpl implements EstadosolicitudBL {

	private EstadosolicitudDAO estadosolicitudDAO;

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.EstadosolicitudBL#guardar(int, java.lang.String)
	 */
	@Override
	public void guardar(int id, String estado) throws DAOException {
		Estadosolicitud estadosolicitud=null;
		if(Validaciones.isTextoVacio(String.valueOf(id))){
			throw new DAOException("Debe ingresar un id para el estado de solicitud");
		}
		if(Validaciones.isTextoVacio(estado)){
			throw new DAOException("Debe ingresar un estado valido");
		}
		estadosolicitud=estadosolicitudDAO.obtenerPorId(id);
		if(estadosolicitud!=null){
			throw new DAOException("El estado con el id: "+id+" ya existe");
		}
		estadosolicitud = new Estadosolicitud(id,estado);
		estadosolicitudDAO.guardar(estadosolicitud);
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.EstadosolicitudBL#actualizar(int, java.lang.String)
	 */
	@Override
	public void actualizar(int id, String estado) throws DAOException {
		Estadosolicitud estadosolicitud=null;
		if(Validaciones.isTextoVacio(String.valueOf(id))){
			throw new DAOException("Debe ingresar un id para el estado de solicitud");
		}
		if(Validaciones.isTextoVacio(estado)){
			throw new DAOException("Debe ingresar un estado valido");
		}
		estadosolicitud=estadosolicitudDAO.obtenerPorId(id);
		if(estadosolicitud==null){
			throw new DAOException("El estado con el id: "+id+" no existe existe");
		}
		estadosolicitud = new Estadosolicitud(id,estado);
		estadosolicitudDAO.actualizar(estadosolicitud);
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.EstadosolicitudBL#borrar(int)
	 */
	@Override
	public void borrar(int id) throws DAOException {
		if(Validaciones.isTextoVacio(String.valueOf(id))){
			throw new DAOException("Debe ingresar un id para el estado de solicitud");
		}
		Estadosolicitud estadosolicitud=null;
		estadosolicitud=estadosolicitudDAO.obtenerPorId(id);
		if(estadosolicitud==null){
			throw new DAOException("No existe el estado en la base de datos");
		}
		estadosolicitudDAO.borrar(id);
	}
	
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.EstadosolicitudBL#obtenerTodos()
	 */
	@Override
	public List<Estadosolicitud> obtenerTodos () throws DAOException{
		return estadosolicitudDAO.obtenerTodos();
	}
	
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.EstadosolicitudBL#obtenerPorId(int)
	 */
	@Override
	public Estadosolicitud obtenerPorId (Integer id) throws DAOException{
		if(Validaciones.isTextoVacio(String.valueOf(id))){
			throw new DAOException("Debe ingresar un id para el estado de solicitud");
		}
		Estadosolicitud resultado = estadosolicitudDAO.obtenerPorId(id);
		if(resultado==null){
			throw new DAOException("No existe ningun estado de solicitud con el id ingresado");
		}
		return resultado;
	}

	public EstadosolicitudDAO getEstadosolicitudDAO() {
		return estadosolicitudDAO;
	}

	public void setEstadosolicitudDAO(EstadosolicitudDAO estadosolicitudDAO) {
		this.estadosolicitudDAO = estadosolicitudDAO;
	}
}

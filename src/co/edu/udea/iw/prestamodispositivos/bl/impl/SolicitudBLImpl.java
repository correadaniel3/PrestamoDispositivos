/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl.impl;

import java.util.Date;
import java.util.List;
import co.edu.udea.iw.prestamodispositivos.bl.SolicitudBL;
import co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO;
import co.edu.udea.iw.prestamodispositivos.dao.EstadosolicitudDAO;
import co.edu.udea.iw.prestamodispositivos.dao.SolicitudDAO;
import co.edu.udea.iw.prestamodispositivos.dao.UsuarioDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo;
import co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud;
import co.edu.udea.iw.prestamodispositivos.modelo.Solicitud;
import co.edu.udea.iw.prestamodispositivos.modelo.Usuario;

/**
 * Clase que implementa los métodos de la logica del negocio para la tabla de la base de datos solicitud
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class SolicitudBLImpl implements SolicitudBL {

	private SolicitudDAO solicitudDAO;
	private DispositivoDAO dispositivoDAO;
	private UsuarioDAO usuarioDAO;
	private EstadosolicitudDAO estadosolicitudDAO;

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.SolicitudBL#guardar(java.lang.Integer, co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo, co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud, co.edu.udea.iw.prestamodispositivos.modelo.Usuario, int, java.util.Date, java.util.Date)
	 */
	@Override
	public void guardar(Dispositivo dispositivo, Usuario usuario,
			int cantidad, Date fechainicio, Date fechafin) throws DAOException {
		if(dispositivo==null){
			throw new DAOException("No ha seleccionado un dispositivo valido");
		}
		if(dispositivoDAO.obtenerPorId(dispositivo.getId())==null){
			throw new DAOException("El dispositivo no existe en la base de datos");
		}
		if(usuario==null){
			throw new DAOException("No se ha detectado el usuario correctamente");
		}
		if(usuarioDAO.obtenerPorId(usuario.getNombreusuario())==null){
			throw new DAOException("El usuario no existe en la base de datos");
		}
		if(cantidad<=0 || ((Integer)cantidad)==null){
			throw new DAOException("La cantidad no es valida");
		}
		if(fechainicio==null){
			throw new DAOException("La fecha de inicio no es valida");
		}
		if(fechafin==null){
			throw new DAOException("La fecha de finalizacion no es valida");
		}
		long diff = (fechafin.getTime() - fechainicio.getTime())/1000;//Para validacion de tiempo maximo 8 horas
        if(diff>28800){
        	throw new DAOException("El tiempo maximo de un prestamo son 8 horas, el tiempo excede este valor");
        }
		List<Solicitud> todas = solicitudDAO.obtenerPorDispositivo(dispositivo.getId(),fechainicio,fechafin);
		int cantidadUsada = 0;
		for(Solicitud sol:todas){
			if(sol.getEstadosolicitud().getId()==2 || sol.getEstadosolicitud().getId()==5 || sol.getEstadosolicitud().getId()==6){
				cantidadUsada+=sol.getCantidad();
			}
		}
		if((dispositivo.getCantidad()-cantidadUsada)<cantidad){
        	throw new DAOException("La cantidad de dispositivos requeridos no esta disponible");
		}
		Estadosolicitud estadoPorDefecto = new Estadosolicitud();
		estadoPorDefecto.setId(2);
		Solicitud nueva = new Solicitud(dispositivo, estadoPorDefecto, usuario, cantidad, fechainicio, fechafin, new Date());
		solicitudDAO.guardar(nueva);
	}
	
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.SolicitudBL#actualizar(java.lang.Integer, co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo, co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud, co.edu.udea.iw.prestamodispositivos.modelo.Usuario, int, java.util.Date, java.util.Date, co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud)
	 */
	@Override
	public void actualizar(Integer id, Dispositivo dispositivo, Usuario usuario, int cantidad, Date fechainicio, Date fechafin,
			Estadosolicitud estadosolicitud) throws DAOException {
		if(id==null){
			throw new DAOException("Ingrese un id valido");
		}
		if(solicitudDAO.obtenerPorId(id)==null){
			throw new DAOException("No existe ninguna solicitud con el id ingresado");
		}
		if(dispositivo==null){
			throw new DAOException("No ha seleccionado un dispositivo valido");
		}
		if(dispositivoDAO.obtenerPorId(dispositivo.getId())==null){
			throw new DAOException("El dispositivo no existe en la base de datos");
		}
		if(usuario==null){
			throw new DAOException("No se ha detectado el usuario correctamente");
		}
		if(usuarioDAO.obtenerPorId(usuario.getNombreusuario())==null){
			throw new DAOException("El usuario no existe en la base de datos");
		}
		if(estadosolicitud==null){
			throw new DAOException("No se ha seleccionado un estado de solicitud valido");
		}
		if(estadosolicitudDAO.obtenerPorId(estadosolicitud.getId())==null){
			throw new DAOException("El estado de solicitud seleccionado no existe en la base de datos");
		}
		if(cantidad<=0 || ((Integer)cantidad)==null){
			throw new DAOException("La cantidad no es valida");
		}
		if(fechainicio==null){
			throw new DAOException("La fecha de inicio no es valida");
		}
		if(fechafin==null){
			throw new DAOException("La fecha de finalizacion no es valida");
		}
		long diff = (fechafin.getTime() - fechainicio.getTime())/1000;//Para validacion de tiempo maximo 8 horas
        if(diff>28800){
        	throw new DAOException("El tiempo maximo de un prestamo son 8 horas, el tiempo excede este valor");
        }
		List<Solicitud> todas = solicitudDAO.obtenerPorDispositivo(dispositivo.getId(), fechainicio,fechafin);
		int cantidadUsada = 0;
		for(Solicitud sol:todas){
			if(sol.getEstadosolicitud().getId()==2 || sol.getEstadosolicitud().getId()==5 || sol.getEstadosolicitud().getId()==6){
				cantidadUsada+=sol.getCantidad();
			}
		}
		if((dispositivo.getCantidad()-cantidadUsada)<cantidad){
        	throw new DAOException("La cantidad de dispositivos requeridos no esta disponible");
		}
		Solicitud nueva = new Solicitud(dispositivo, estadosolicitud, usuario, cantidad, fechainicio, fechafin, new Date());
		nueva.setId(id);
		solicitudDAO.actualizar(nueva);
	}

	public SolicitudDAO getSolicitudDAO() {
		return solicitudDAO;
	}

	public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}
	
	public DispositivoDAO getDispositivoDAO() {
		return dispositivoDAO;
	}

	public void setDispositivoDAO(DispositivoDAO dispositivoDAO) {
		this.dispositivoDAO = dispositivoDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public EstadosolicitudDAO getEstadosolicitudDAO() {
		return estadosolicitudDAO;
	}

	public void setEstadosolicitudDAO(EstadosolicitudDAO estadosolicitudDAO) {
		this.estadosolicitudDAO = estadosolicitudDAO;
	}
}

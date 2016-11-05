/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl.impl;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.prestamodispositivos.bl.TipodocumentoBL;
import co.edu.udea.iw.prestamodispositivos.dao.TipodocumentoDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento;
import co.edu.udea.iw.prestamodispositivos.util.validations.Validaciones;

/**
 * Clase que implementa los métodos de la logica del negocio para la tabla tipodocumento de la base de datos usuario
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
@Transactional
public class TipodocumentoBLImpl implements TipodocumentoBL {
	
	private TipodocumentoDAO tipodocumentoDAO;

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.TipodocumentoBL#guardar(int, java.lang.String)
	 */
	@Override
	public void guardar(int id, String tipo) throws DAOException {
		Tipodocumento tipodocumento=null;
		if(Validaciones.isTextoVacio(String.valueOf(id))){
			throw new DAOException("Debe ingresar un id para el tipo de documento");
		}
		if(Validaciones.isTextoVacio(tipo)){
			throw new DAOException("Debe ingresar un tipo de documento");
		}
		tipodocumento=tipodocumentoDAO.obtenerPorId(id);
		if(tipodocumento!=null){
			throw new DAOException("El tipo de documento con el id: "+id+" ya existe");
		}
		tipodocumento=new Tipodocumento(id, tipo);
		tipodocumentoDAO.guardar(tipodocumento);
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.TipodocumentoBL#actualizar(int, java.lang.String)
	 */
	@Override
	public void actualizar(int id, String tipo) throws DAOException {
		Tipodocumento tipodocumento=null;
		if(Validaciones.isTextoVacio(String.valueOf(id))){
			throw new DAOException("Debe ingresar un id para el tipo de documento");
		}
		if(Validaciones.isTextoVacio(tipo)){
			throw new DAOException("Debe ingresar un tipo de documento");
		}
		tipodocumento=tipodocumentoDAO.obtenerPorId(id);
		if(tipodocumento==null){
			throw new DAOException("No existe un tipo de documento con el id proporcionado");
		}
		tipodocumento.setId(id);
		tipodocumento.setTipo(tipo);
		tipodocumentoDAO.actualizar(tipodocumento);

	}
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.TipodocumentoBL#borrar(int)
	 */
	@Override
	public void borrar(int id) throws DAOException {
		if(Validaciones.isTextoVacio(String.valueOf(id))){
			throw new DAOException("Debe ingresar un id para el tipo de documento");
		}
		Tipodocumento tipodocumento=null;
		tipodocumento=tipodocumentoDAO.obtenerPorId(id);
		if(tipodocumento==null){
			throw new DAOException("No existe el tipo de documento en la base de datos");
		}
		tipodocumentoDAO.borrar(id);
	}
	
	@Override
	public Tipodocumento obtenerPorID(int id) throws DAOException {
		Tipodocumento tipodocumento=null;
		if(Validaciones.isTextoVacio(String.valueOf(id))){
			throw new DAOException("Debe ingresar un id para el tipo de documento");
		}
		tipodocumento = tipodocumentoDAO.obtenerPorId(id);
		if(tipodocumento==null){
			throw new DAOException("No existe el tipo de documento en la base de datos");
		}
		return tipodocumento;
	}

	public TipodocumentoDAO getTipodocumentoDAO() {
		return tipodocumentoDAO;
	}

	public void setTipodocumentoDAO(TipodocumentoDAO tipodocumentoDAO) {
		this.tipodocumentoDAO = tipodocumentoDAO;
	}		 
}

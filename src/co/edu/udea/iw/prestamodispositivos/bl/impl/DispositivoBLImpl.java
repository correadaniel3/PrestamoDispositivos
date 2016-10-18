/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.bl.impl;

import co.edu.udea.iw.prestamodispositivos.bl.DispositivoBL;
import co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo;
import co.edu.udea.iw.prestamodispositivos.util.validations.Validaciones;

/**
 * Clase que implementa los métodos de la logica del negocio para la tabla dispositivo de la base de datos usuario
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class DispositivoBLImpl implements DispositivoBL {

	private DispositivoDAO dispositivoDAO;
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.DispositivoBL#guardar(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, byte[])
	 */
	@Override
	public void guardar(String marca, String modelo, String nombre, String descripcion,
			int cantidad, byte[] imagen) throws DAOException{
		
		Dispositivo dispositivo=null;
		if(Validaciones.isTextoVacio(marca)){
			throw new DAOException("No ha ingresado la marca del dispositivo");
		}
		if(Validaciones.isTextoVacio(modelo)){
			throw new DAOException("No ha ingresado el modelo del dispositivo");
		}
		if(Validaciones.isTextoVacio(nombre)){
			throw new DAOException("No ha ingresado el nombre del dispositivo");
		}
		if(Validaciones.isTextoVacio(descripcion)){
			throw new DAOException("No ha ingresado la descripcion del dispositivo");
		}
		if(Validaciones.isTextoVacio(String.valueOf(cantidad))){
			throw new DAOException("No ha ingresado la cantidad de dispositivos");
		}
		if(imagen==null){
			dispositivo=new Dispositivo(marca,modelo,nombre,descripcion,cantidad);
		}else{
			dispositivo=new Dispositivo(marca,modelo,nombre,descripcion,cantidad,imagen);
		}
		dispositivoDAO.guardar(dispositivo);

	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.DispositivoBL#actualizar(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, byte[])
	 */
	@Override
	public void actualizar(Integer id,String marca, String modelo, String nombre, String descripcion, int cantidad, byte[] imagen) throws DAOException{
		Dispositivo dispositivo=null;
		
		if(Validaciones.isTextoVacio(String.valueOf(id))){
			throw new DAOException("No ha ingresado el id del dispositivo a actualizar");
		}
		dispositivo=dispositivoDAO.obtenerPorId(id);
		
		if(Validaciones.isTextoVacio(marca)){
			throw new DAOException("No ha ingresado la marca del dispositivo");
		}
		if(Validaciones.isTextoVacio(modelo)){
			throw new DAOException("No ha ingresado el modelo del dispositivo");
		}
		if(Validaciones.isTextoVacio(nombre)){
			throw new DAOException("No ha ingresado el nombre del dispositivo");
		}
		if(Validaciones.isTextoVacio(descripcion)){
			throw new DAOException("No ha ingresado la descripcion del dispositivo");
		}
		if(Validaciones.isTextoVacio(String.valueOf(cantidad))){
			throw new DAOException("No ha ingresado la cantidad de dispositivos");
		}
		dispositivo.setMarca(marca);
		dispositivo.setModelo(modelo);
		dispositivo.setNombre(nombre);
		dispositivo.setDescripcion(descripcion);
		dispositivo.setCantidad(cantidad);
		if(imagen!=null){
			dispositivo.setImagen(imagen);
		}
		dispositivoDAO.actualizar(dispositivo);

	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.bl.DispositivoBL#borrar(int)
	 */
	@Override
		// TODO Auto-generated method stub
	public void borrar(int id) throws DAOException {
		if(Validaciones.isTextoVacio(String.valueOf(id))){
			throw new DAOException("No ha ingresado el id del dispositivo a borrar");
		}
		Dispositivo dispositivo=dispositivoDAO.obtenerPorId(id);
		if(dispositivo==null){
			throw new DAOException("No existe el dispositivo con el id: "+id+" en la base de datos");
		}
		dispositivoDAO.borrar(id);

	}

}

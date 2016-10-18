/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.prestamodispositivos.dao.EstadosolicitudDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud;

/**
 * Clase que implementa la interfaz EstadosolicitudDAO
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class EstadosolicitudDAOImpl implements EstadosolicitudDAO {

	private SessionFactory sessionFactory;
	

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.dao.EstadosolicitudDAO#obtenerTodos()
	 */
	@Override
	public List<Estadosolicitud> obtenerTodos() throws DAOException {
		Session session = null;
		List<Estadosolicitud> resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Estadosolicitud.class);
			resultado = criteria.list();
		}catch(HibernateException e){
			throw new DAOException(e);
		}finally{
			try{
				if(session!=null)session.close();
			}catch(HibernateException e){
				throw new DAOException(e);
			}
		}
		return resultado;
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.dao.EstadosolicitudDAO#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud)
	 */
	@Override
	public void guardar(Estadosolicitud estadosolicitud) throws DAOException {
		Session session = null;
		Transaction transaccion = null;
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.save(estadosolicitud);
			transaccion.commit();
		}catch(HibernateException e){
			throw new DAOException(e);
		}finally{
			try{
				if(session!=null)session.close();
			}catch(HibernateException e){
				throw new DAOException(e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.dao.EstadosolicitudDAO#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Estadosolicitud)
	 */
	@Override
	public void actualizar(Estadosolicitud estadosolicitud) throws DAOException {
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.update(estadosolicitud);
		}catch(HibernateException e){
			throw new DAOException(e);
		}finally{
			try{
				if(session!=null)session.close();
			}catch(HibernateException e){
				throw new DAOException(e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.dao.EstadosolicitudDAO#borrar(java.lang.Integer)
	 */
	@Override
	public void borrar(Integer id) throws DAOException {
		Session session = null;
		Estadosolicitud estadosolicitud = new Estadosolicitud();
		estadosolicitud.setId(id);
		try{
			session = sessionFactory.openSession();
			session.delete(estadosolicitud);
		}catch(HibernateException e){
			throw new DAOException(e);
		}finally{
			try{
				if(session!=null)session.close();
			}catch(HibernateException e){
				throw new DAOException(e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.dao.EstadosolicitudDAO#obtenerPorId(java.lang.Integer)
	 */
	@Override
	public Estadosolicitud obtenerPorId(Integer id) throws DAOException {
		Session session = null;
		Estadosolicitud resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Estadosolicitud.class).add(Restrictions.eq("id",id));
			resultado = (Estadosolicitud)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new DAOException(e);
		}finally{
			try{
				if(session!=null)session.close();
			}catch(HibernateException e){
				throw new DAOException(e);
			}
		}
		return resultado;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

/**
 * 
 */
package co.edu.udea.iw.prestamodispositivos.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO;
import co.edu.udea.iw.prestamodispositivos.dao.SolicitudDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Solicitud;

/**
 * Clase que implementa la interfaz SolicitudDAO
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class SolicitudDAOImpl implements SolicitudDAO {

	private SessionFactory sessionFactory;
	private DispositivoDAO dispositivoDAO;

	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.dao.SolicitudDAO#obtenerTodos()
	 */
	@Override
	public List<Solicitud> obtenerTodos() throws DAOException {
		Session session = null;
		List<Solicitud> resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Solicitud.class);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.SolicitudDAO#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Solicitud)
	 */
	@Override
	public void guardar(Solicitud solicitud) throws DAOException {
		Session session = null;
		Transaction transaccion = null;
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.save(solicitud);
			transaccion.commit();
		}catch(HibernateException e){
			transaccion.rollback();
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.SolicitudDAO#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Solicitud)
	 */
	@Override
	public void actualizar(Solicitud solicitud) throws DAOException {
		Session session = null;
		Transaction transaccion = null;
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.update(solicitud);
			transaccion.commit();
		}catch(HibernateException e){
			transaccion.rollback();
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.SolicitudDAO#obtenerPorId(java.lang.Integer)
	 */
	@Override
	public Solicitud obtenerPorId(Integer id) throws DAOException {
		Session session = null;
		Solicitud resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Solicitud.class).add(Restrictions.eq("id",id));
			resultado = (Solicitud)criteria.uniqueResult();
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.SolicitudDAO#obtenerPorDispositivo(java.lang.Integer, java.util.Date, java.util.Date)
	 */
	@Override
	public List<Solicitud> obtenerPorDispositivo(Integer id, Date fechainicio, Date fechafin) throws DAOException {
		Session session = null;
		List<Solicitud> resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Solicitud.class)
					.add(Restrictions.eq("dispositivo", dispositivoDAO.obtenerPorId(id)));
			criteria.add(Restrictions.between("fechainicio", fechainicio, fechafin));
			criteria.add(Restrictions.between("fechafin", fechainicio, fechafin));
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
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public DispositivoDAO getDispositivoDAO() {
		return dispositivoDAO;
	}

	public void setDispositivoDAO(DispositivoDAO dispositivoDAO) {
		this.dispositivoDAO = dispositivoDAO;
	}
	
}

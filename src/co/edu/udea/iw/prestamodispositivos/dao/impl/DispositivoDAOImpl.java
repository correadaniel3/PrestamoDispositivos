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

import co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo;

/**
 * Clase que implementa la interfaz DispositivoDAO
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class DispositivoDAOImpl implements DispositivoDAO {
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO#obtenerTodos()
	 */
	@Override
	public List<Dispositivo> obtenerTodos() throws DAOException {
		Session session = null;
		List<Dispositivo> resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Dispositivo.class);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo)
	 */
	@Override
	public void guardar(Dispositivo dispositivo) throws DAOException {
		Session session = null;
		Transaction transaccion = null;
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.save(dispositivo);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Dispositivo)
	 */
	@Override
	public void actualizar(Dispositivo dispositivo) throws DAOException {
		Session session = null;
		Transaction transaccion=null;
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.update(dispositivo);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO#borrar(java.lang.Integer)
	 */
	@Override
	public void borrar(Integer id) throws DAOException {
		Session session = null;
		Transaction transaccion=null;
		Dispositivo dispositivo = new Dispositivo();
		dispositivo= obtenerPorId(id);
		dispositivo.setCantidad(0);
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.update(dispositivo);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.DispositivoDAO#obtenerPorId(java.lang.Integer)
	 */
	@Override
	public Dispositivo obtenerPorId(Integer id) throws DAOException {
		Session session = null;
		Dispositivo resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Dispositivo.class).add(Restrictions.eq("id",id));
			resultado = (Dispositivo)criteria.uniqueResult();
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
	
	@Override
	public Dispositivo obtener(String marca, String modelo, String nombre) throws DAOException {
		Session session = null;
		Dispositivo resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Dispositivo.class)
					.add(Restrictions.eq("marca",marca))
					.add(Restrictions.eq("modelo", modelo))
					.add(Restrictions.eq("nombre", nombre));
			resultado = (Dispositivo)criteria.uniqueResult();
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

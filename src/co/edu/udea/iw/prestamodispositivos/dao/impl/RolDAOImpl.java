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

import co.edu.udea.iw.prestamodispositivos.dao.RolDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Rol;
import co.edu.udea.iw.prestamodispositivos.modelo.Solicitud;

/**
 * Clase que implementa la interfaz RolDAO
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class RolDAOImpl implements RolDAO {
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.dao.RolDAO#obtenerTodos()
	 */
	@Override
	public List<Rol> obtenerTodos() throws DAOException {
		Session session = null;
		List<Rol> resultado = null;
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.RolDAO#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Rol)
	 */
	@Override
	public void guardar(Rol rol) throws DAOException {
		Session session = null;
		Transaction transaccion = null;
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.save(rol);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.RolDAO#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Rol)
	 */
	@Override
	public void actualizar(Rol rol) throws DAOException {
		Session session = null;
		try{
			session = sessionFactory.openSession();
			session.update(rol);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.RolDAO#borrar(int)
	 */
	@Override
	public void borrar(int id) throws DAOException {
		Session session = null;
		Solicitud solicitud = new Solicitud();
		solicitud.setId(id);
		try{
			session = sessionFactory.openSession();
			session.delete(solicitud);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.RolDAO#obtenerPorId(int)
	 */
	@Override
	public Rol obtenerPorId(int id) throws DAOException {
		Session session = null;
		Rol resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Rol.class).add(Restrictions.eq("id",id));
			resultado = (Rol)criteria.uniqueResult();
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

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

import co.edu.udea.iw.prestamodispositivos.dao.TipodocumentoDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento;

/**
 * Clase que implementa la interfaz TipodocumentoDAO
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class TipodocumentoDAOImpl implements TipodocumentoDAO {
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.dao.TipodocumentoDAO#obtenerTodos()
	 */
	@Override
	public List<Tipodocumento> obtenerTodos() throws DAOException {
		Session session = null;
		List<Tipodocumento> resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Tipodocumento.class);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.TipodocumentoDAO#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento)
	 */
	@Override
	public void guardar(Tipodocumento tipodocumento) throws DAOException {
		Session session = null;
		Transaction transaccion = null;
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.save(tipodocumento);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.TipodocumentoDAO#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Tipodocumento)
	 */
	@Override
	public void actualizar(Tipodocumento tipodocumento) throws DAOException {
		Session session = null;
		Transaction transaccion = null;
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.update(tipodocumento);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.TipodocumentoDAO#borrar(int)
	 */
	@Override
	public void borrar(int id) throws DAOException {
		Session session = null;
		Transaction transaccion = null;
		Tipodocumento tipoDoc = new Tipodocumento();
		tipoDoc.setId(id);
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.delete(tipoDoc);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.TipodocumentoDAO#obtenerPorId(int)
	 */
	@Override
	public Tipodocumento obtenerPorId(int id) throws DAOException {
		Session session = null;
		Tipodocumento resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Tipodocumento.class)
					.add(Restrictions.eq("id",id));
			resultado = (Tipodocumento)criteria.uniqueResult();
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

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

import co.edu.udea.iw.prestamodispositivos.dao.UsuarioDAO;
import co.edu.udea.iw.prestamodispositivos.exception.DAOException;
import co.edu.udea.iw.prestamodispositivos.modelo.Solicitud;
import co.edu.udea.iw.prestamodispositivos.modelo.Usuario;

/**
 * Clase que implementa la interfaz UsuarioDAO
 * @author Leon David Osorio Tobon - leond.osorio@udea.edu.co - Universidad de Antioquia
 * @author Daniel Correa Arango - daniel.correa3@udea.edu.co - Universidad de Antioquia
 * @author Frank Alexis Castrillon Giraldo - frank.castrillon@udea.edu.co - Universidad de Antioquia
 */
public class UsuarioDAOImpl implements UsuarioDAO {
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see co.edu.udea.iw.prestamodispositivos.dao.UsuarioDAO#obtenerTodos()
	 */
	@Override
	public List<Usuario> obtenerTodos() throws DAOException {
		Session session = null;
		List<Usuario> resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Usuario.class);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.UsuarioDAO#guardar(co.edu.udea.iw.prestamodispositivos.modelo.Usuario)
	 */
	@Override
	public void guardar(Usuario usuario) throws DAOException {
		Session session = null;
		Transaction transaccion = null;
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.save(usuario);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.UsuarioDAO#actualizar(co.edu.udea.iw.prestamodispositivos.modelo.Usuario)
	 */
	@Override
	public void actualizar(Usuario usuario) throws DAOException {
		Session session = null;
		Transaction transaccion = null;
		try{
			session = sessionFactory.openSession();
			transaccion = session.beginTransaction();
			session.update(usuario);
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
	 * @see co.edu.udea.iw.prestamodispositivos.dao.UsuarioDAO#obtenerPorId(java.lang.String)
	 */
	@Override
	public Usuario obtenerPorId(String nombreusuario) throws DAOException {
		Session session = null;
		Usuario resultado = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Usuario.class)
					.add(Restrictions.eq("nombreusuario",nombreusuario));
			resultado = (Usuario)criteria.uniqueResult();
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

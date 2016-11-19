package com.ccl.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.BaseDao;

@Repository
@Transactional
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	protected SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Session getNewSession() {
		return sessionFactory.openSession();
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	public T load(Class<T> c, Serializable id) {
		Session session = getSession();
		return session.get(c, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllList(Class<T> c) {
		String hql = "from " + c.getName();
		Session session = getSession();
		return session.createQuery(hql).list();

	}

	public int getTotalCount(Class<T> c) {
		Session session = getNewSession();
		String hql = "select count(*) from " + c.getName();
		Object result = session.createQuery(hql).uniqueResult();
		int count = 0;
		if (result != null) {
			count = (Integer)result;
		}
		session.close();
		return count;
	}

	public void save(T bean) throws DuplicateKeyException{
		try {
			Session session = getNewSession();
			session.save(bean);
			session.flush();
			session.clear();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DuplicateKeyException("重复PK,Bean:  " + bean.getClass());
		}
	}

	public void update(T bean) {
		Session session = getNewSession();
		session.update(bean);
		session.flush();
		session.clear();
		session.close();
	}

	public void delete(T bean) {

		Session session = getNewSession();
		session.delete(bean);
		session.flush();
		session.clear();
		session.close();
	}

	public void delete(Class<T> c, Serializable id) {
		Session session = getNewSession();
		T obj = session.get(c, id);
		session.delete(obj);
		session.flush();
		session.clear();
		session.close();
	}

	public void delete(Class<T> c, Serializable[] ids) {
		Session session = getNewSession();
		for (Serializable id : ids) {
			T obj = session.get(c, id);
			if (obj != null) {
				session.delete(obj);
			}
		}
		session.flush();
		session.clear();
		session.close();
	}

	@Override
	public T findById(Class<T> c, Serializable key) {
		Session session = getNewSession();
		T result;
		try{
			 result = session.get(c, key);
		}catch(Exception e){
			return null;
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findByColumn(Class<T> cl, String column, Serializable value) {
		Session s = getSession();
		Criteria c = s.createCriteria(cl);
		c.add(Restrictions.eq(column, value));
		List<T> list = c.list();
		if (list != null && list.size() != 0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.BaseDao#deleteByColumns(java.lang.Class, java.lang.String, java.io.Serializable, java.lang.String, java.io.Serializable)
	 */
	@Override
	public void deleteByColumns(Class<T> cl, String column1, Serializable value1, String column2, Serializable value2) {
		T result = findByColumns(cl, column1, value1, column2, value2);
		if (result != null) {
			delete(result);
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.BaseDao#findByColumns(java.lang.Class, java.lang.String, java.io.Serializable, java.lang.String, java.io.Serializable)
	 */
	@Override
	public T findByColumns(Class<T> cl, String column1, Serializable value1, String column2, Serializable value2) {
		Session s = getSession();
		Criteria c = s.createCriteria(cl);
		c.add(Restrictions.eq(column1, value1));
		c.add(Restrictions.eq(column2, value2));
		@SuppressWarnings("unchecked")
		List<T> list = c.list();
		if (list != null && list.size() != 0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.BaseDao#getListByColumn(java.lang.Class, java.lang.String, java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getListByColumn(Class<T> cl, String column, Serializable value) {
		Session s = getSession();
		Criteria c = s.createCriteria(cl);
		c.add(Restrictions.eq(column, value));
		return c.list();
	}
	

}

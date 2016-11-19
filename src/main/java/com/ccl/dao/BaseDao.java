package com.ccl.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.dao.DuplicateKeyException;


public interface BaseDao<T> {

	public Session getSession();

	public Session getNewSession();
	
	public T findById(Class<T> c, Serializable id);
	
	public void flush();

	public void clear() ;

	public T load(Class<T> c, Serializable id) ;


	public List<T> getAllList(Class<T> c) ;
	
	public int getTotalCount(Class<T> c) ;

	public void save(T bean) throws DuplicateKeyException;

	public void update(T bean) ;

	public void delete(T bean) ;
	
	public void delete(Class<T> c, Serializable id) ;

	public void delete(Class<T> c, Serializable[] ids) ;
	
	public T findByColumn(Class<T> c, String column, Serializable value);
	
	public void deleteByColumns(Class<T> c, String column1, Serializable value1, String column2, Serializable value2);
	
	public T findByColumns(Class<T> c, String column1, Serializable value1, String column2, Serializable value2);
	
	public List<T> getListByColumn(Class<T> cl, String column, Serializable value);
}

/**
 * 
 */
package com.ccl.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.UserDao;
import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月13日 上午11:00:42
 * @version 1.0
 */
@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	
	/* (non-Javadoc)
	 * @see com.ccl.dao.UserDao#getAllTeacherUser()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllTeacherUser() {
		Session s = getNewSession();
		Criteria c = s.createCriteria(User.class);
		c.add(Restrictions.eq("userType", 0));
		List<User> list = c.list();
		s.close();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.UserDao#getAllStudentUser()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllStudentUser() {
		Session s = getNewSession();
		Criteria c = s.createCriteria(User.class);
		c.add(Restrictions.eq("userType", 1));
		List<User> list = c.list();
		s.close();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.UserDao#searchTeacherUser()
	 */
	@Override
	public List<User> searchTeacherUser(String key) {
		Session s = getNewSession();
		Criteria c = s.createCriteria(User.class);
		String like = "%" + key + "%";
		c.add(Restrictions.eq("userType", 0));
		c.add(Restrictions.or(Restrictions.like("email", like), 
				Restrictions.like("tel", like), Restrictions.like("username", like)));
		@SuppressWarnings("unchecked")
		List<User> list = c.list();
		s.close();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.UserDao#searchStudentUser()
	 */
	@Override
	public List<User> searchStudentUser(String key) {
		Session s = getNewSession();
		Criteria c = s.createCriteria(User.class);
		String like = "%" + key + "%";
		c.add(Restrictions.eq("userType", 1));
		c.add(Restrictions.or(Restrictions.like("email", like), 
				Restrictions.like("tel", like), Restrictions.like("username", like)));
		@SuppressWarnings("unchecked")
		List<User> list = c.list();
		s.close();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.UserDao#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String uid) {
		// TODO Auto-generated method stub
		
	}

}

/**
 * 
 */
package com.ccl.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.TeachDao;
import com.ccl.model.Teach;

/**
 *
 * @author 霄汉
 * @since 2016年3月16日 下午4:34:17
 * @version 1.0
 */
@Repository
@Transactional
public class TeachDaoImpl extends BaseDaoImpl<Teach> implements TeachDao{

	/* (non-Javadoc)
	 * @see com.ccl.dao.TeachDao#getTeacherStringByCid(int)
	 */
	@Override
	public String getTeacherStringByCid(int cid) {
		String teachers = "";
		Session s = getNewSession();
		String sql = "select u.username from User u, Teach t where t.uid=u.uid and t.cid='"+cid+"'";
		@SuppressWarnings("unchecked")
		List<String> result = s.createQuery(sql).list();
		s.close();
		for (String row : result) {
			teachers += row;
			teachers += ",";
		}
		if (teachers.length() > 0) {
			return teachers.substring(0, teachers.length() - 1);
		}else {
			return teachers;
		}
		
	}

}

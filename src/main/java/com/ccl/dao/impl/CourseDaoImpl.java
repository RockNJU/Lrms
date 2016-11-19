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

import com.ccl.dao.CourseDao;
import com.ccl.model.Course;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 下午6:31:22
 * @version 1.0
 */
@Repository
@Transactional
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao{

	/* (non-Javadoc)
	 * @see com.ccl.dao.CourseDao#getUnscheduledCourse()
	 */
	@Override
	public List<Course> getUnscheduledCourse() {
			Session s = getNewSession();
			Criteria c = s.createCriteria(Course.class);
			c.add(Restrictions.eq("state", 0));
			@SuppressWarnings("unchecked")
			List<Course> list = c.list();
			s.close();
			return list;
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.CourseDao#getScheduledCourse()
	 */
	@Override
	public List<Course> getScheduledCourse() {
		Session s = getNewSession();
		Criteria c = s.createCriteria(Course.class);
		c.add(Restrictions.not(Restrictions.eq("state", 0)));
		@SuppressWarnings("unchecked")
		List<Course> list = c.list();
		s.close();
		return list;
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.CourseDao#getMyTeachCourse(java.lang.String)
	 */
	@Override
	public List<Course> getMyTeachCourse(String uid) {
		Session s = getNewSession();
		String hql = "select c from Course c, Teach t where t.uid='" + uid + "' and t.cid=c.cid";
		@SuppressWarnings("unchecked")
		List<Course> courses = s.createQuery(hql).list();
		s.close();
		return courses;
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.CourseDao#getMyAttendCourse(java.lang.String)
	 */
	@Override
	public List<Course> getMyAttendCourse(String uid) {
		Session s = getNewSession();
		String hql = "select c from Course c, Selection s where s.uid='" + uid + "' and s.cid=c.cid";
		@SuppressWarnings("unchecked")
		List<Course> courses = s.createQuery(hql).list();
		s.close();
		return courses;
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.CourseDao#getMyAssistCourse(java.lang.String)
	 */
	@Override
	public List<Course> getMyAssistCourse(String uid) {
		Session s = getNewSession();
		String hql = "select c from Course c, Assist a where a.uid='" + uid + "' and a.cid=c.cid";
		@SuppressWarnings("unchecked")
		List<Course> courses = s.createQuery(hql).list();
		s.close();
		return courses;
	}
	
	

}

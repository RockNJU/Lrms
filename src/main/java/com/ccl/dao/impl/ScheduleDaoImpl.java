/**
 * 
 */
package com.ccl.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.ScheduleDao;
import com.ccl.model.Schedule;

/**
 *
 * @author 霄汉
 * @since 2016年3月16日 下午5:13:43
 * @version 1.0
 */
@Repository
@Transactional
public class ScheduleDaoImpl extends BaseDaoImpl<Schedule> implements ScheduleDao{

	/* (non-Javadoc)
	 * @see com.ccl.dao.ScheduleDao#getSemesterName(int)
	 */
	@Override
	public String getSemesterName(int cid) {
		Session s = getNewSession();
		String sql = "select seme.semestername from Schedule sche, Semester seme where sche.semesterid=seme.semesterid and sche.cid='"+cid+"'";
		@SuppressWarnings("unchecked")
		List<String> result = s.createQuery(sql).list();
		s.close();
		if (result==null || result.size()==0) {
			return null;
		}else {
			return result.get(0);
		}
	}
	

}

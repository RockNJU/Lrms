/**
 * 
 */
package com.ccl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccl.dao.CourseDao;
import com.ccl.dao.SelectionDao;
import com.ccl.dao.TeachDao;
import com.ccl.model.Course;
import com.ccl.model.Selection;
import com.ccl.model.Teach;
import com.ccl.service.ManageCourseService;
import com.ccl.vo.ScheduledCourseVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 下午6:29:51
 * @version 1.0
 */
@Service
public class ManageCourseServiceImpl implements ManageCourseService{
	
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private TeachDao teachDao;
	@Autowired
	private SelectionDao selectionDao;

	/* (non-Javadoc)
	 * @see com.ccl.service.CourseService#addCourse(com.ccl.model.Course)
	 */
	@Override
	public boolean addCourse(Course course, String [] tids) {
		courseDao.save(course);
		int cid = course.getCid();
		for (String tid : tids) {
			Teach teach = new Teach();
			teach.setCid(cid);
			teach.setTid(tid);
			teach.setCreatedAt(new Date());
			teachDao.save(teach);
			Selection selection = new Selection();
			selection.setCid(cid);
			selection.setUid(tid);
			selection.setCreatedAt(new Date());
			selectionDao.save(selection);
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.CourseService#getUnscheduledCourse()
	 */
	@Override
	public List<ScheduledCourseVO> getUnscheduledCourse() {
		ArrayList<ScheduledCourseVO> vos = new ArrayList<ScheduledCourseVO>();
		List<Course> courses = courseDao.getUnscheduledCourse();
		for (Course c : courses) {
			vos.add(new ScheduledCourseVO(c, teachDao, null));
		}
		return vos;
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.CourseService#delCourse(java.lang.String)
	 */
	@Override
	public boolean delCourse(int cid) {
		courseDao.delete(Course.class, cid);
		return true;
	}
	
	

}

/**
 * 
 */
package com.ccl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccl.dao.CourseDao;
import com.ccl.model.Course;
import com.ccl.service.impl.MyCourseService;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 上午9:03:49
 * @version 1.0
 */
@Service
public class MyCourseServiceImpl implements MyCourseService{
	
	@Autowired
	private CourseDao courseDao;

	/* (non-Javadoc)
	 * @see com.ccl.service.impl.MyCourseService#getMyTeachCourse(java.lang.String)
	 */
	@Override
	public List<Course> getMyTeachCourse(String uid) {
		return courseDao.getMyTeachCourse(uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.impl.MyCourseService#getMyAttendCourse(java.lang.String)
	 */
	@Override
	public List<Course> getMyAttendCourse(String uid) {
		return courseDao.getMyAttendCourse(uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.impl.MyCourseService#getMyAssistCourse(java.lang.String)
	 */
	@Override
	public List<Course> getMyAssistCourse(String uid) {
		return courseDao.getMyAssistCourse(uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.impl.MyCourseService#getCourseInfo(int)
	 */
	@Override
	public Course getCourseInfo(int cid) {
		return courseDao.findByColumn(Course.class, "cid", cid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.impl.MyCourseService#getExcel()
	 */
	@Override
	public String getExcel() {
		// TODO Auto-generated method stub
		return "F:/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ccl/excels/summary.xlsx";
	}
	
	

}

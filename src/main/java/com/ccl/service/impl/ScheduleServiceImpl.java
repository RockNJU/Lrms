/**
 * 
 */
package com.ccl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccl.dao.CourseDao;
import com.ccl.dao.ScheduleDao;
import com.ccl.dao.SemesterDao;
import com.ccl.dao.TeachDao;
import com.ccl.model.Course;
import com.ccl.model.Schedule;
import com.ccl.model.Semester;
import com.ccl.service.ScheduleService;
import com.ccl.vo.ScheduledCourseVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月16日 下午5:09:24
 * @version 1.0
 */
@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private SemesterDao semesterDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private TeachDao teachDao;
	@Autowired
	private ScheduleDao scheduleDao;

	/* (non-Javadoc)
	 * @see com.ccl.service.ScheduleService#getSemesters()
	 */
	@Override
	public List<Semester> getSemesters() {
		return semesterDao.getAllList(Semester.class);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.ScheduleService#getUnscheduledCourses()
	 */
	@Override
	public List<ScheduledCourseVO> getUnscheduledCourses() {
		ArrayList<ScheduledCourseVO> result = new ArrayList<ScheduledCourseVO>();
		List<Course> pos = courseDao.getUnscheduledCourse();
		for (Course c : pos) {
			result.add(new ScheduledCourseVO(c, teachDao, scheduleDao));
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.ScheduleService#addSchedule(int, int, java.lang.String)
	 */
	@Override
	public boolean addSchedule(int cid, int semesterid, String comment) {
		Schedule s = new Schedule();
		s.setCid(cid);
		s.setSemesterid(semesterid);
		s.setComment(comment);
		scheduleDao.save(s);
		Course c = courseDao.findById(Course.class, cid);
		c.setState(1);
		courseDao.update(c);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.ScheduleService#getScheduledCourses()
	 */
	@Override
	public List<ScheduledCourseVO> getScheduledCourses() {
		ArrayList<ScheduledCourseVO> result = new ArrayList<ScheduledCourseVO>();
		List<Course> pos = courseDao.getScheduledCourse();
		for (Course c : pos) {
			result.add(new ScheduledCourseVO(c, teachDao, scheduleDao));
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.ScheduleService#delSchedule(int)
	 */
	@Override
	public boolean delSchedule(int cid) {
		scheduleDao.delete(Schedule.class, cid);
		Course c = courseDao.findById(Course.class, cid);
		c.setState(0);
		courseDao.update(c);
		return true;
	}

}

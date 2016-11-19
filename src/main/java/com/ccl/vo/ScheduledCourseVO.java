/**
 * 
 */
package com.ccl.vo;

import com.ccl.dao.ScheduleDao;
import com.ccl.dao.TeachDao;
import com.ccl.model.Course;

/**
 *
 * @author 霄汉
 * @since 2016年3月16日 下午4:35:43
 * @version 1.0
 */
public class ScheduledCourseVO {
	private int cid;
	private String coursename;
	private int credit;	//学分数
	private String description;	//项目描述
	private String teacher;
	private String semesterName;
	
	public ScheduledCourseVO(Course course, TeachDao teachDao, ScheduleDao scheduleDao) {
		this.cid = course.getCid();
		this.coursename = course.getCoursename();
		this.credit = course.getCredit();
		this.description = course.getDescription();
		this.teacher = teachDao.getTeacherStringByCid(this.cid);
		if (course.getState() != 0) {
			this.setSemesterName("999");
		}
	}

	public int getCid() {
		return cid;
	}

	public String getCoursename() {
		return coursename;
	}

	public int getCredit() {
		return credit;
	}

	public String getDescription() {
		return description;
	}

	public String getTeacher() {
		return teacher;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

}

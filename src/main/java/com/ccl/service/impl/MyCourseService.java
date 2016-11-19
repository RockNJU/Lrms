/**
 * 
 */
package com.ccl.service.impl;

import java.util.List;

import com.ccl.model.Course;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 上午8:57:11
 * @version 1.0
 */
public interface MyCourseService {
	
	public List<Course> getMyTeachCourse(String uid);
	
	public List<Course> getMyAttendCourse(String uid);
	
	public List<Course> getMyAssistCourse(String uid);
	
	public Course getCourseInfo(int cid);
	
	public String getExcel();

}

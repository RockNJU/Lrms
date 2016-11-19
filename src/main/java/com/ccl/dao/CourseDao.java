/**
 * 
 */
package com.ccl.dao;

import java.util.List;

import com.ccl.model.Course;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 下午6:30:42
 * @version 1.0
 */
public interface CourseDao extends BaseDao<Course>{
	
	public List<Course> getUnscheduledCourse();
	
	public List<Course> getScheduledCourse();
	
	public List<Course> getMyTeachCourse(String uid);
	
	public List<Course> getMyAttendCourse(String uid);
	
	public List<Course> getMyAssistCourse(String uid);

}

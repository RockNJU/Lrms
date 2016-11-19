/**
 * 
 */
package com.ccl.service;

import java.util.List;

import com.ccl.model.Semester;
import com.ccl.vo.ScheduledCourseVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月16日 下午4:25:15
 * @version 1.0
 */
public interface ScheduleService {
	
	public List<Semester> getSemesters();
	
	public List<ScheduledCourseVO> getUnscheduledCourses();
	
	public List<ScheduledCourseVO> getScheduledCourses();
	
	public boolean addSchedule(int cid, int semesterid, String comment);
	
	public boolean delSchedule(int cid);

}

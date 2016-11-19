/**
 * 
 */
package com.ccl.service;

import java.util.List;

import com.ccl.model.Course;
import com.ccl.vo.ScheduledCourseVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 下午6:27:22
 * @version 1.0
 */
public interface ManageCourseService {
	
	public boolean addCourse(Course course, String[] tids);
	
	public List<ScheduledCourseVO> getUnscheduledCourse();
	
	public boolean delCourse(int cid);

}

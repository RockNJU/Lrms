/**
 * 
 */
package com.ccl.action.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.Semester;
import com.ccl.service.ScheduleService;
import com.ccl.vo.ScheduledCourseVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月16日 下午4:24:34
 * @version 1.0
 */
@Controller
public class SchedulePageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1544225536395029718L;

	@Autowired
	private ScheduleService service;
	
	private List<Semester> semesters;
	
	private List<ScheduledCourseVO> courses;
	
	public String execute() {
		semesters = service.getSemesters();
		courses = service.getUnscheduledCourses();
		return SUCCESS;
	}

	public List<Semester> getSemesters() {
		return semesters;
	}

	public List<ScheduledCourseVO> getCourses() {
		return courses;
	}


}

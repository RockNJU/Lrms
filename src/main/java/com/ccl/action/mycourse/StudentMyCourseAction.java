/**
 * 
 */
package com.ccl.action.mycourse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.model.Course;
import com.ccl.service.impl.MyCourseService;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 上午9:06:36
 * @version 1.0
 */
@Controller
public class StudentMyCourseAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4748769468914958439L;

	@Autowired
	private MyCourseService service;
	
	private List<Course> myAttendCourse;
	
	private List<Course> myAssistCourse;
	
	public String execute() {
		String uid = Utility.getUser(request).getUid();
		this.setMyAttendCourse(service.getMyAttendCourse(uid));
		this.setMyAssistCourse(service.getMyAssistCourse(uid));
		return SUCCESS;
	}

	public List<Course> getMyAttendCourse() {
		return myAttendCourse;
	}

	public void setMyAttendCourse(List<Course> myAttendCourse) {
		this.myAttendCourse = myAttendCourse;
	}

	public List<Course> getMyAssistCourse() {
		return myAssistCourse;
	}

	public void setMyAssistCourse(List<Course> myAssistCourse) {
		this.myAssistCourse = myAssistCourse;
	}

}

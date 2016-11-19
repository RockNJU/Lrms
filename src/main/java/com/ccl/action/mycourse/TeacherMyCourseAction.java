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
 * @since 2016年3月19日 上午9:10:00
 * @version 1.0
 */
@Controller
public class TeacherMyCourseAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2524588043551358807L;

	@Autowired
	private MyCourseService service;
	
	private List<Course> myTeachCourse;
	
	public String execute() {
		String uid = Utility.getUser(request).getUid();
		List<Course> courses = service.getMyAttendCourse(uid);
		this.setMyTeachCourse(courses);
		return SUCCESS;
	}

	public List<Course> getMyTeachCourse() {
		return myTeachCourse;
	}

	public void setMyTeachCourse(List<Course> myTeachCourse) {
		this.myTeachCourse = myTeachCourse;
	}

}

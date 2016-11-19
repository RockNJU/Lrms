/**
 * 
 */
package com.ccl.action.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.User;
import com.ccl.service.UserManageService;

/**
 *
 * @author 霄汉
 * @since 2016年3月18日 下午6:19:38
 * @version 1.0
 */
@Controller
public class CoursePageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8886272614736546074L;

	@Autowired
	private UserManageService userService;
	
	private List<User> teachers;
	
	public String execute() {
		this.setTeachers(userService.getAllTeacherUser());
		return SUCCESS;
		
	}

	public List<User> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<User> teachers) {
		this.teachers = teachers;
	}

}

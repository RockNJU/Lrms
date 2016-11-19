/**
 * 
 */
package com.ccl.action.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.User;
import com.ccl.service.UserManageService;

/**
 *
 * @author 霄汉
 * @since 2016年3月22日 下午3:30:37
 * @version 1.0
 */
@Controller
public class AssignmentsIndependentPageAction extends BaseAction{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2409254090868905610L;

	@Autowired
	private UserManageService service;
	
	private List<User> teachers;

	
	public String execute() {
		teachers = service.getAllTeacherUser();
		return SUCCESS;
	}

	public List<User> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<User> teachers) {
		this.teachers = teachers;
	}

}

/**
 * 
 */
package com.ccl.action.teachcourse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.User;
import com.ccl.service.TeachCourseService;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午6:37:35
 * @version 1.0
 */
@Controller
public class GetStudentToAssistAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6558178555499022808L;

	@Autowired
	private TeachCourseService service;
	
	private List<User> result;
	
	public String execute() {
		int cid = Integer.parseInt(request.getParameter("cid"));
		setResult(service.getStudentsToAssist(cid));
		return SUCCESS;
	}

	public List<User> getResult() {
		return result;
	}

	public void setResult(List<User> result) {
		this.result = result;
	}

}

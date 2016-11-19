/**
 * 
 */
package com.ccl.action.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.AssignmentService;

/**
 *
 * @author 霄汉
 * @since 2016年3月20日 上午8:51:59
 * @version 1.0
 */
@Controller
public class DelAssignmentAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4428296136922971026L;

	@Autowired
	private AssignmentService service;
	
	private String result;
	
	public String execute() {
		int assignmentid = Integer.parseInt(request.getParameter("assignmentid"));
		service.delAssignment(assignmentid);
		setResult("success");
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

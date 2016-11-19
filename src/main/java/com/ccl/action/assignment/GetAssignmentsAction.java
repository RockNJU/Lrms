/**
 * 
 */
package com.ccl.action.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.Assignment;
import com.ccl.service.AssignmentService;

/**
 *
 * @author 霄汉
 * @since 2016年3月20日 上午8:44:59
 * @version 1.0
 */
@Controller
public class GetAssignmentsAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 336487548080667132L;

	@Autowired
	private AssignmentService service;
	
	private List<Assignment> result;
	
	public String execute() {
		int cid = Integer.parseInt(request.getParameter("cid"));

		setResult(service.getAssignments(cid));
		return SUCCESS;
	}

	public List<Assignment> getResult() {
		return result;
	}

	public void setResult(List<Assignment> result) {
		this.result = result;
	}

}

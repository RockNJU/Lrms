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
 * @since 2016年3月21日 下午7:19:10
 * @version 1.0
 */
@Controller
public class ApproveReportAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4142504859666132951L;

	@Autowired
	private AssignmentService service;
	
	private int assignmentid;
	
	public String execute() {
		assignmentid = Integer.parseInt(request.getParameter("assignmentid"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		String operation = request.getParameter("operation");
//		if (operation.equals("approve")) {
//			service.approveReportByAssignmentid(assignmentid);
//		}else {
//			service.disapproveReportByAssignmentid(assignmentid);
//		}
		request.setAttribute("authority", 0);
		request.setAttribute("cid", cid);
		return SUCCESS;
	}
	
	public int getAssignmentid() {
		return assignmentid;
	}

}

/**
 * 
 */
package com.ccl.action.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.Report;
import com.ccl.service.AssignmentService;

/**
 *
 * @author 霄汉
 * @since 2016年3月21日 下午2:27:07
 * @version 1.0
 */
@Controller
public class MarksLookPageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6556102712759673929L;

	@Autowired
	private AssignmentService service;
	
	
	private List<Report> reports;
	
	private int assignmentid;
	
	
	public String execute() {
		assignmentid = Integer.parseInt(request.getParameter("assignmentid"));
		reports = service.getReports(assignmentid);
		return SUCCESS;
	}

	public int getAssignmentid() {
		return assignmentid;
	}




	public AssignmentService getService() {
		return service;
	}



	public void setService(AssignmentService service) {
		this.service = service;
	}



	public List<Report> getReports() {
		return reports;
	}



	public void setReports(List<Report> reports) {
		this.reports = reports;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public void setAssignmentid(int assignmentid) {
		this.assignmentid = assignmentid;
	}

}

/**
 * 
 */
package com.ccl.action.assignment;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.model.Report;
import com.ccl.service.AssignmentService;

/**
 *
 * @author 霄汉
 * @since 2016年3月23日 上午8:31:49
 * @version 1.0
 */
@Controller
public class SubmitReportAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -319473100701075267L;
	
	@Autowired
	AssignmentService assignmentService;
	
	private String result;
	
	private Report report;
	
	public String execute() {
		String uid = Utility.getUser(request).getUid();
		int assignmentid = Integer.parseInt(request.getParameter("assignmentid"));
		if (!assignmentService.isFollower(uid, assignmentid)) {
			result = "deny";
			return SUCCESS;
		}
		String stateDesc = request.getParameter("stateDesc");
		if (stateDesc.equals("risk")) {
			stateDesc = "风险";
		}
		else {
			stateDesc = "问题";
		}
		String content = request.getParameter("content");
		Report report = new Report();
		report.setAssignmentid(assignmentid);
		report.setContent(content);
		report.setCreatedAt(new Date());
		report.setStateDesc(stateDesc);
		report.setUid(uid);
		assignmentService.writeReport(report);
		result = "success";
		return SUCCESS;
	}
	
	public String changeRiskToProblem(){
		if(report==null||report.getReportid()==0){
			result="fail_report_null";
			return SUCCESS;
		}
		return INPUT;
		
		
	}
	
	public String getResult() {
		return result;
	}

	public AssignmentService getAssignmentService() {
		return assignmentService;
	}

	public void setAssignmentService(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public void setResult(String result) {
		this.result = result;
	}


}

package com.ccl.action.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.AssignmentService;
import com.ccl.service.NoticeService;

@Controller
public class ImportAssignmentAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5727284675944260297L;
	@Autowired
	private AssignmentService service;
	@Autowired
	private NoticeService noticeService;
	
	private String result;
	
	public String execute() {
		
			
		int cid = Integer.parseInt(request.getParameter("cid"));
		int assignmentid = Integer.parseInt(request.getParameter("assignmentid"));
		
		
		
		service.importAssignment(cid, assignmentid);
		setResult("success");
		noticeService.sendAssignmentNotice(cid);

		return SUCCESS;

	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

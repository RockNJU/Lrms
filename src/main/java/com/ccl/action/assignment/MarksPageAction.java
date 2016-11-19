/**
 * 
 */
package com.ccl.action.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.Mark;
import com.ccl.model.Report;
import com.ccl.service.AssignmentService;

/**
 *
 * @author 霄汉
 * @since 2016年3月21日 下午2:27:07
 * @version 1.0
 */
@Controller
public class MarksPageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6556102712759673929L;

	@Autowired
	private AssignmentService service;
	
	private List<Mark> marks;
	
	private String reportContent;	
	
	private int assignmentid;
	
	private int cid;
	
	
	
	public String execute() {
		assignmentid = Integer.parseInt(request.getParameter("assignmentid"));
		cid = Integer.parseInt(request.getParameter("cid"));
		setMarks(service.getMarks(assignmentid));
		Report report = service.getReport(assignmentid);
		if (report == null) {
			setReportContent("");
		}else {
			setReportContent(report.getContent());
		}
		return SUCCESS;
	}



	public List<Mark> getMarks() {
		return marks;
	}
	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	public int getAssignmentid() {
		return assignmentid;
	}



	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}

}

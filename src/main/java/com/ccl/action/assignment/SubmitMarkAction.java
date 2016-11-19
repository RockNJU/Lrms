/**
 * 
 */
package com.ccl.action.assignment;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.Mark;
import com.ccl.model.Report;
import com.ccl.service.AssignmentService;

import net.sf.json.JSONArray;

/**
 *
 * @author 霄汉
 * @since 2016年3月21日 下午4:14:49
 * @version 1.0
 */
@Controller
public class SubmitMarkAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5661641033088588000L;
	@Autowired
	private AssignmentService service;
	
	private String result;
	
	public String execute() {
		String content = request.getParameter("content");
		int assignmentid = Integer.parseInt(request.getParameter("assignmentid"));
		Report report = new Report();
		report.setAssignmentid(assignmentid);
		report.setContent(content);
		report.setCreatedAt(new Date());
//		report.setState(0);
		service.writeReport(report);
		
		ArrayList<Mark> newMarks = new ArrayList<Mark>();
		
		JSONArray jsonArray = JSONArray.fromObject(request.getParameter("list"));
		
		for (int i=0;i<jsonArray.size();i++) {
			JSONArray row = JSONArray.fromObject(jsonArray.getString(i));
			String uid = row.getString(0);
			double mark = row.getDouble(1);
			String comment = row.getString(2);
			Mark newMark = new Mark();
			newMark.setComment(comment);
			newMark.setCreatedAt(new Date());
			newMark.setMark(mark);
			newMark.setUid(uid);
			newMark.setAssignmentid(assignmentid);
			newMarks.add(newMark);
		}
		
		service.writeMarks(newMarks);
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

/**
 * 
 */
package com.ccl.action.semester;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.model.Semester;
import com.ccl.service.SemesterService;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 上午11:47:24
 * @version 1.0
 */
@Controller
public class AddSemesterAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4549583589006965448L;

	@Autowired
	private SemesterService service;
	
	private String result;
	
	public String execute() {
		String name = request.getParameter("semestername");
		Date start = Utility.parseDate(request.getParameter("startDate"));
		Date end = Utility.parseDate(request.getParameter("endDate"));
		String comment = request.getParameter("comment");
		if (end.before(start)) {
			setResult("fail");
			return SUCCESS;
		}
		Semester semester = new Semester();
		semester.setComment(comment);
		semester.setEndDate(end);
		semester.setSemestername(name);
		semester.setStartDate(start);
		boolean flag = service.addSemester(semester);
		if (flag) {
			setResult("success");
			return SUCCESS;
		}else {
			setResult("fail");
			return SUCCESS;
		}
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	

}

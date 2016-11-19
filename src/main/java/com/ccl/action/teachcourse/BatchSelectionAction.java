/**
 * 
 */
package com.ccl.action.teachcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.TeachCourseService;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午6:38:29
 * @version 1.0
 */
@Controller
public class BatchSelectionAction extends BaseAction{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 547474001056647550L;

	@Autowired
	private TeachCourseService service;
	
	private String result;
	
	public String execute() {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String start = request.getParameter("startuid");
		String end = request.getParameter("enduid");
		setResult(service.batchSelectCourse(cid, start, end));
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

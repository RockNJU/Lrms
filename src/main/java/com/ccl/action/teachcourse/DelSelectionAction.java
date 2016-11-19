/**
 * 
 */
package com.ccl.action.teachcourse;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccl.action.BaseAction;
import com.ccl.service.TeachCourseService;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午6:38:43
 * @version 1.0
 */
public class DelSelectionAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8332338088872275437L;

	@Autowired
	private TeachCourseService service;
	
	private String result;
	
	public String execute() {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String uid = request.getParameter("uid");
		service.delSelection(cid, uid);
		result = "success";
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}



}

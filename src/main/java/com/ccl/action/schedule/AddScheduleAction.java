/**
 * 
 */
package com.ccl.action.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.ScheduleService;

/**
 *
 * @author 霄汉
 * @since 2016年3月16日 下午5:20:29
 * @version 1.0
 */
@Controller
public class AddScheduleAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3827368153621868755L;

	@Autowired
	private ScheduleService service;
	
	private String result;
	
	public String execute() {
		try {
			int cid = Integer.parseInt(request.getParameter("cid"));
			int semesterid = Integer.parseInt(request.getParameter("semesterid"));
			String comment = request.getParameter("comment");
			service.addSchedule(cid, semesterid, comment);
			setResult("success");
		}catch(Exception e) {
			setResult("fail");
		}
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

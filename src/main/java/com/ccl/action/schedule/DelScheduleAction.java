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
 * @since 2016年3月17日 下午4:30:38
 * @version 1.0
 */
@Controller
public class DelScheduleAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6499527858977284945L;

	@Autowired
	private ScheduleService service;
	
	private String result;
	
	public String execute() {
		int cid = Integer.parseInt(request.getParameter("cid"));
		service.delSchedule(cid);
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

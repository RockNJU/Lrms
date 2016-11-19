/**
 * 
 */
package com.ccl.action.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.ScheduleService;

import net.sf.json.JSONArray;

/**
 *
 * @author 霄汉
 * @since 2016年3月17日 上午9:43:51
 * @version 1.0
 */
@Controller
public class GetScheduledCoursesAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 448871635959153617L;

	@Autowired
	private ScheduleService service;
	
	private JSONArray result;
	
	public String execute() {
		this.setResult(JSONArray.fromObject(service.getScheduledCourses()));
		return SUCCESS;
	}

	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

}

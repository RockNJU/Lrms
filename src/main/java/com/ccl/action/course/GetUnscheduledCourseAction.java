/**
 * 
 */
package com.ccl.action.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.ManageCourseService;

import net.sf.json.JSONArray;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 下午7:46:17
 * @version 1.0
 */
@Controller
public class GetUnscheduledCourseAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2195864122295961961L;

	@Autowired
	private ManageCourseService service;
	
	private JSONArray result;
	
	public String execute() {
		setResult(JSONArray.fromObject(service.getUnscheduledCourse()));
		return SUCCESS;
	}

	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

}

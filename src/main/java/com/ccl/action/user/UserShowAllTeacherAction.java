/**
 * 
 */
package com.ccl.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.UserManageService;

import net.sf.json.JSONArray;

/**
 *
 * @author 霄汉
 * @since 2016年3月13日 上午9:48:19
 * @version 1.0
 */
@Controller
public class UserShowAllTeacherAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6319826375713896429L;

	@Autowired
	private UserManageService service;
	
	private JSONArray result;
	
	
	
	public String execute() {
		JSONArray teacherArray = new JSONArray();
		teacherArray.addAll(service.getAllTeachers());
		JSONArray userArray = new JSONArray();
		userArray.addAll(service.getAllTeacherUser());
		result = new JSONArray();
		result.add(teacherArray);
		result.add(userArray);
		return SUCCESS;
	}


	public JSONArray getResult() {
		return result;
	}


	public void setResult(JSONArray result) {
		this.result = result;
	}



}

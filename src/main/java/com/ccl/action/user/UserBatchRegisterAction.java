/**
 * 
 */
package com.ccl.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.UserRegisterService;

/**
 *
 * @author 霄汉
 * @since 2016年3月13日 上午8:52:52
 * @version 1.0
 */
@Controller
public class UserBatchRegisterAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6816126828255139269L;

	@Autowired
	private UserRegisterService service;
	
	private String result;
	
	public String execute() {
		String start = request.getParameter("startuid");
		String end = request.getParameter("enduid");
		setResult(service.batchRegister(start, end));
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

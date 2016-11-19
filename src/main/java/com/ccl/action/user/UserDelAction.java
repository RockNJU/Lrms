/**
 * 
 */
package com.ccl.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.UserManageService;

/**
 *
 * @author 霄汉
 * @since 2016年3月13日 下午4:19:35
 * @version 1.0
 */
@Controller
public class UserDelAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4036919685160889019L;

	@Autowired
	private UserManageService service;
	
	private String result;
	
	public String execute() {
		boolean flag = service.deleteUser(request.getParameter("uid"));
		if (flag) {
			setResult("success");
		}else {
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

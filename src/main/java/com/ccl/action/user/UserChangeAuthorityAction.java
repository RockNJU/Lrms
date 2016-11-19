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
 * @since 2016年3月13日 下午3:40:48
 * @version 1.0
 */
@Controller
public class UserChangeAuthorityAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4120915350764212131L;

	@Autowired
	private UserManageService service;
	
	private String result;
	
	public String execute() {
		String uid = request.getParameter("uid");
		boolean isDirector = Boolean.parseBoolean(request.getParameter("isDirector"));
		boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));
		boolean flag = service.changeAuthority(uid, isDirector, isAdmin);
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

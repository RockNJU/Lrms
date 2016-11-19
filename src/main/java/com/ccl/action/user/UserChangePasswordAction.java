/**
 * 
 */
package com.ccl.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.service.UserInfoService;

/**
 *
 * @author 霄汉
 * @since 2016年3月9日 上午10:42:40
 * @version 1.0
 */
@Controller
public class UserChangePasswordAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5702371094661507894L;
	@Autowired
	private UserInfoService service;
	private String result;
	
	public String execute() {
		String oldpw = request.getParameter("oldpw");
		String newpw = request.getParameter("newpw");
		String uid = Utility.getUser(request).getUid();
		boolean flag = service.changePassword(uid, oldpw, newpw);
		if (flag) {
			result = ("success");
			return SUCCESS;
		}else {
			result = ("fail");
			return SUCCESS;
		}
	}
	
	public String getResult() {
		return result;
	}

}

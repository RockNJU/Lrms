/**
 * 
 */
package com.ccl.action.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.User;
import com.ccl.service.UserInfoService;

/**
 *
 * @author 霄汉
 * @since 2016年3月7日 下午8:41:05
 * @version 1.0
 */
@Controller
public class UserProfileAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3823135649826252435L;

	@Autowired
	private UserInfoService service;

	public String execute() {
		
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String uid = ((User)session.get("user")).getUid();
		boolean flag = service.updateUserInfo(uid, email, tel);
		if (flag) {
			User newUser = service.getUser(uid);
			request.getSession().setAttribute("user", newUser);
			return SUCCESS;
		}else {
			return INPUT;
		}
	}


}

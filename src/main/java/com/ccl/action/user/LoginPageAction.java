/**
 * 
 */
package com.ccl.action.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.User;
import com.ccl.service.UserManageService;
import com.ccl.service.UserRegisterService;

/**
 *
 * @author 霄汉
 * @since 2016年3月8日 下午6:38:59
 * @version 1.0
 */
@Controller
public class LoginPageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5379649607230486377L;

	
	public String execute() {
		return SUCCESS;
	}

}

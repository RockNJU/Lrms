/**
 * 
 */
package com.ccl.action.user;

import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;

/**
 *
 * @author 霄汉
 * @since 2016年3月9日 上午10:07:15
 * @version 1.0
 */
@Controller
public class LogoutAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 39599735293733707L;

	public String execute() {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("student");
		request.getSession().removeAttribute("teacher");
		request.getSession().invalidate();
		return SUCCESS;
	}

}

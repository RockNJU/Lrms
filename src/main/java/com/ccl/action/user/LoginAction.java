/**
 * 
 */
package com.ccl.action.user;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.Assist;
import com.ccl.model.Selection;
import com.ccl.model.Student;
import com.ccl.model.Teach;
import com.ccl.model.Teacher;
import com.ccl.model.User;
import com.ccl.service.UserLoginService;
import com.ccl.service.UserManageService;
import com.ccl.service.UserRegisterService;

/**
 *
 * @author éœ„æ±‰
 * @since 2016å¹´3æœˆ7æ—¥ ä¸‹å�ˆ2:22:21
 * @version 1.0
 */
@Controller
public class LoginAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4887398627940782L;
	@Autowired
	private UserLoginService loginService;
	@Autowired
	private UserRegisterService registerService;
	@Autowired
	private UserManageService manageService;
	
	public String execute() {
		List<User> curUsers = manageService.getAllTeacherUser();
		if (curUsers == null || curUsers.size() == 0) {
			//åˆ�å§‹åŒ–adminè´¦å�·
			registerService.registerAdmin();
		}
		
		String uid = request.getParameter("uid");
		User result = loginService.login(uid, request.getParameter("password"));
		if (result != null) {
			request.getSession().setAttribute("user", result);
			int userType = result.getUserType();
			if (userType == 0) {
				Teacher teacher = loginService.getTeacher(uid);
				request.getSession().setAttribute("teacher", teacher);
			}else {
				Student student = loginService.getStudent(uid);
				request.getSession().setAttribute("student", student);
			}
			request.getSession().removeAttribute("errorMessage");
			
			//0è€�å¸ˆ 1å�‚ä¸Žè€… 2åŠ©æ•™
			HashMap<Integer, Integer> authorityMap = new HashMap<Integer, Integer>();
//			if (result.getUserType() == 0) {
//				List<Teach> teaches = loginService.getUserAllTeach(uid);
//				for (Teach t : teaches) {
//					authorityMap.put(t.getCid(), 0);
//				}
//			}else {
//				List<Assist> assists = loginService.getUserAllAssist(uid);
//				for (Assist t : assists) {
//					authorityMap.put(t.getCid(), 2);
//				}
//				List<Selection> selections = loginService.getUserAllSelection(uid);
//				for (Selection t : selections) {
//					authorityMap.put(t.getCid(), 1);
//				}
//			}
			
			
			List<Selection> selections = loginService.getUserAllSelection(uid);
			for (Selection t : selections) {
				authorityMap.put(t.getCid(), 1);
			}
			
				List<Teach> teaches = loginService.getUserAllTeach(uid);
				for (Teach t : teaches) {
					authorityMap.put(t.getCid(), 0);
				}
			

			
			request.getSession().setAttribute("authorityMap", authorityMap);
			return SUCCESS;
		}else {
			loginService.setErrorMessage(request);
			return INPUT;
		}
	}
}

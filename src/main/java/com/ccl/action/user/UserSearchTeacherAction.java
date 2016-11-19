/**
 * 
 */
package com.ccl.action.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.User;
import com.ccl.service.UserManageService;

import net.sf.json.JSONArray;

/**
 *
 * @author 霄汉
 * @since 2016年3月14日 上午8:36:20
 * @version 1.0
 */
@Controller
public class UserSearchTeacherAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7158272139858939750L;

	@Autowired
	private UserManageService service;
	
	private JSONArray result;
	
	public String execute() {
		String key = request.getParameter("key");
		List<User> users = service.searchTeacherUser(key);
		JSONArray userArray = new JSONArray();
		userArray.addAll(users);
		JSONArray teacherArray = new JSONArray();
		for (User u : users) {
			teacherArray.add(service.getTeacher(u.getUid()));
		}
		result = new JSONArray();
		result.add(teacherArray);
		result.add(userArray);
		System.out.println(users.size());
		return SUCCESS;
	}

	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

}

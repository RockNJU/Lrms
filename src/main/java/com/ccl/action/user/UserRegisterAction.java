/**
 * 
 */
package com.ccl.action.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.UserRegisterService;

import net.sf.json.JSONArray;


/**
 *
 * @author 霄汉
 * @since 2016年3月12日 下午4:01:52
 * @version 1.0
 */
@Controller
public class UserRegisterAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2123665259609898913L;

	@Autowired
	private UserRegisterService service;
	
	private String result;
	
	public String execute() {
		String str = request.getParameter("uidlist");
		JSONArray jsonArray = JSONArray.fromObject(str);
		ArrayList<String> uids = new ArrayList<String>();
		for (int i=0;i<jsonArray.size();i++) {
			String s = jsonArray.getString(i);
			if (s != null && s.length() !=0) {
				uids.add(s);
			}
		}
		result = service.register(uids);
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

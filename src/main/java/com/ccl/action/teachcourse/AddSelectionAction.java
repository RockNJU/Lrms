/**
 * 
 */
package com.ccl.action.teachcourse;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.service.NoticeService;
import com.ccl.service.TeachCourseService;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午6:38:20
 * @version 1.0
 */
@Controller
public class AddSelectionAction extends BaseAction{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7631625965539614580L;

	@Autowired
	private TeachCourseService service;
	@Autowired
	private NoticeService noticeService;
	
	private String result;
	
	public String execute() {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String [] uids = request.getParameter("uid").split("-");
		ArrayList<String> list = new ArrayList<String>();
		for (String s : uids) {
			list.add(s);
			noticeService.sendStudentNotice(cid, s);
		}
		setResult(service.selectCourse(cid, list));
		
		String curUid = Utility.getUser(request).getUid();
		for (String uid : uids) {
			if (uid.equals(curUid)) {
				HashMap<Integer, Integer> authorityMap = (HashMap<Integer, Integer>)(request.getSession().getAttribute("authorityMap"));
				if (!authorityMap.containsKey(cid))
					authorityMap.put(cid, 1);
				break;
			}
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

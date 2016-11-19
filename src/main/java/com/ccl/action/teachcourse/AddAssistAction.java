/**
 * 
 */
package com.ccl.action.teachcourse;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.NoticeService;
import com.ccl.service.TeachCourseService;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午6:39:00
 * @version 1.0
 */
@Controller
public class AddAssistAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1213059050482117278L;

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
			noticeService.sendAssistNotice(cid, s);
		}
		setResult(service.assistCourse(cid, list));
		
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

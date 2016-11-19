/**
 * 
 */
package com.ccl.action.course;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.model.Course;
import com.ccl.service.ManageCourseService;
import com.ccl.service.NoticeService;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 下午6:19:09
 * @version 1.0
 */
@Controller
public class AddCourseAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5058163943552453269L;

	@Autowired
	private ManageCourseService service;
	@Autowired
	private NoticeService noticeService;
	
	private String result;
	
	public String execute() {
		String name = request.getParameter("coursename");
		int credit = Integer.parseInt(request.getParameter("credit"));
		String desc = request.getParameter("description");
		Course course = new Course();
		course.setCoursename(name);
		course.setCreatedAt(new Date());
		course.setCredit(credit);
		course.setDescription(desc);
		course.setState(0);
		
		String teachers = request.getParameter("teachers");
		String [] ids = teachers.split("-");
		service.addCourse(course, ids);
		String curUid = Utility.getUser(request).getUid();
		for (String uid : ids) {
			if (uid.equals(curUid)) {
				HashMap<Integer, Integer> authorityMap = (HashMap<Integer, Integer>)(request.getSession().getAttribute("authorityMap"));
				authorityMap.put(course.getCid(), 0);
				break;
			}
		}
		
		setResult("success");
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

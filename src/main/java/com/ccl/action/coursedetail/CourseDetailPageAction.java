/**
 * 
 */
package com.ccl.action.coursedetail;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.Course;
import com.ccl.service.impl.MyCourseService;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午12:10:18
 * @version 1.0
 */
@Controller
public class CourseDetailPageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -390473103129345116L;
	
	@Autowired
	private MyCourseService service;
	
	private Course course;
	
	private int authority;

	public String execute() {
		@SuppressWarnings("unchecked")
		HashMap<Integer, Integer> authorityMap = (HashMap<Integer, Integer>)(request.getSession().getAttribute("authorityMap"));
//		for (Integer i : authorityMap.keySet()) {
//			System.out.println(i);
//			System.out.println(authorityMap.get(i));
//		}
		int cid = Integer.parseInt(request.getParameter("cid"));
		setCourse(service.getCourseInfo(cid));
		setAuthority(authorityMap.get(cid));
		return SUCCESS;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

}

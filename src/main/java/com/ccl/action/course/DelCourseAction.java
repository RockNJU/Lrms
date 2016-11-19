/**
 * 
 */
package com.ccl.action.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.ManageCourseService;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 下午8:09:59
 * @version 1.0
 */
@Controller
public class DelCourseAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4407643523598024839L;

	@Autowired
	private ManageCourseService service;
	
	private String result;
	
	public String execute() {
		String cid = request.getParameter("cid");
		boolean flag = service.delCourse(Integer.parseInt(cid));
		if (flag) {
			setResult("success");
		}else{
			setResult("fail");
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

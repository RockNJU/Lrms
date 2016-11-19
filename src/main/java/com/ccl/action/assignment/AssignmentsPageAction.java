/**
 * 
 */
package com.ccl.action.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.User;
import com.ccl.service.AssignmentService;

/**
 *
 * @author 霄汉
 * @since 2016年3月22日 下午3:30:37
 * @version 1.0
 */
@Controller
public class AssignmentsPageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8068459078099242603L;
	private int cid;
	
	@Autowired
	private AssignmentService assignmentService;
	
	private List<User> teachers;
	
	private String authority;
			
	
	public String execute() {
		this.setAuthority(request.getParameter("authority"));
		cid = Integer.parseInt(request.getParameter("cid"));
		this.setTeachers(assignmentService.getUserInProject(cid));
		return "teacher";
//		if (authority.equals("0")) {
//			return "teacher";
//		}else if (authority.equals("1")) {
//			return "student";
//		}else {
//			return "assist";
//		}
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public List<User> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<User> teachers) {
		this.teachers = teachers;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}

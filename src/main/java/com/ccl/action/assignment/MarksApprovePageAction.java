/**
 * 
 */
package com.ccl.action.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.model.Assignment;
import com.ccl.model.Report;
import com.ccl.model.Teacher;
import com.ccl.model.User;
import com.ccl.service.AssignmentService;
import com.ccl.service.UserManageService;

/**
 *
 * @author 霄汉
 * @since 2016年3月21日 下午2:27:07
 * @version 1.0
 */
@Controller
public class MarksApprovePageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6556102712759673929L;

	@Autowired
	private AssignmentService service;
	@Autowired
	private UserManageService manageService;
	
	
	private List<Report> reports;
	
	private int assignmentid;
	
	private int cid;
	
	private Assignment assignment;
	
	private List<User> followList;
	
	private List<User> userList;
	
	private String isFollow;
	
	
	public String execute() {
		assignmentid = Integer.parseInt(request.getParameter("assignmentid"));
		reports = service.getReports(assignmentid);
		assignment=service.getAssignment(assignmentid);
		followList=service.getFollowsByAssignmentid(assignmentid);
		boolean isF=service.isFollower(Utility.getUser(request).getUid(), assignmentid);
		if(isF){
			isFollow="true";
		}else{
			isFollow="false";
		}
		System.out.println(isFollow);
		if(cid>0){
			userList=service.getUserInProject(cid);
		}else{
			userList=manageService.getAllTeacherUser();
		}
		return SUCCESS;
	}

	public int getAssignmentid() {
		return assignmentid;
	}




	public AssignmentService getService() {
		return service;
	}



	public void setService(AssignmentService service) {
		this.service = service;
	}



	public List<Report> getReports() {
		return reports;
	}



	public void setReports(List<Report> reports) {
		this.reports = reports;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public void setAssignmentid(int assignmentid) {
		this.assignmentid = assignmentid;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public List<User> getFollowList() {
		return followList;
	}

	public void setFollowList(List<User> followList) {
		this.followList = followList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public UserManageService getManageService() {
		return manageService;
	}

	public void setManageService(UserManageService manageService) {
		this.manageService = manageService;
	}

	public String getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(String isFollow) {
		this.isFollow = isFollow;
	}


}

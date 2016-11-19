package com.ccl.action.assignment;

import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;

@Controller
public class ImportAssignmentPageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1261751538112739646L;
	private int cid;
	
	private int authority;
	
	
	public String execute() {
		this.setAuthority(Integer.parseInt(request.getParameter("authority")));
		this.cid = Integer.parseInt(request.getParameter("cid"));
		return SUCCESS;
	}



	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getAuthority() {
		return authority;
	}


	public void setAuthority(int authority) {
		this.authority = authority;
	}

}

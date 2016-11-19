/**
 * 
 */
package com.ccl.action.assignment;

import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;

/**
 *
 * @author 霄汉
 * @since 2016年3月20日 上午10:53:19
 * @version 1.0
 */
@Controller
public class DownloadAssignmentsAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6403467193694413545L;
	
	private String result;

	public String execute() {
		int assignmentid = Integer.parseInt(request.getParameter("assignmentid"));
		result = Utility.zipAssignments(request, assignmentid);
		System.out.println(result);
		if (result == null) {
			result = "empty";
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

/**
 * 
 */
package com.ccl.action.assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.AssignmentService;
import com.ccl.vo.SubmissionInfoVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月20日 下午2:39:51
 * @version 1.0
 */
@Controller
public class GetSubmissionInfoAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6210560498407655162L;

	@Autowired
	private AssignmentService service;
	
	private List<SubmissionInfoVO> result;
	
	public String execute() {
		String uid = request.getParameter("uid");
		int cid = Integer.parseInt(request.getParameter("cid"));
		setResult(service.getSubmissionInfo(cid, uid));
		return SUCCESS;
	}

	public List<SubmissionInfoVO> getResult() {
		return result;
	}

	public void setResult(List<SubmissionInfoVO> result) {
		this.result = result;
	}

}

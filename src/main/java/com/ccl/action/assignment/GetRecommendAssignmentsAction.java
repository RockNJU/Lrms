/**
 * 
 */
package com.ccl.action.assignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.model.Assignment;
import com.ccl.service.AssignmentService;
import com.ccl.vo.StatisticsVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月20日 上午8:44:59
 * @version 1.0
 */
@Controller
public class GetRecommendAssignmentsAction extends BaseAction{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6589749613536230815L;

	@Autowired
	private AssignmentService service;
	
	private List<List<StatisticsVO>> result;
	
	public String execute() {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Date startDate = Utility.parseDate(request.getParameter("startDate"));
		Date endDate = Utility.parseDate(request.getParameter("endDate"));
		
		result = new ArrayList<List<StatisticsVO>>();
		result.add(service.getRecomendRecoAssignmentToImport(startDate, endDate, cid));
		result.add(service.getRecomendProbAssignmentToImport(startDate, endDate, cid));

		return SUCCESS;
	}

	public List<List<StatisticsVO>> getResult() {
		return result;
	}

	public void setResult(List<List<StatisticsVO>> result) {
		this.result = result;
	}

}

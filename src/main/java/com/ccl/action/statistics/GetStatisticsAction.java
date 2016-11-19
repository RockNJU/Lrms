/**
 * 
 */
package com.ccl.action.statistics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.service.StatisticsService;
import com.ccl.vo.StatisticsVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月21日 下午9:36:20
 * @version 1.0
 */
@Controller
public class GetStatisticsAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2919733935238067748L;

	@Autowired
	private StatisticsService service;
	
	private List<List<StatisticsVO>> result;	//0是响应最多，1是问题最多
	
	public String execute() {
		Date start = Utility.parseDate(request.getParameter("startDate"));
		Date end = Utility.parseDate(request.getParameter("endDate"));
		List<List<StatisticsVO>> result = new ArrayList<List<StatisticsVO>>();
		result.add(service.getRecoStatics(start, end));
		result.add(service.getProbStatics(start, end));
		setResult(result);
		return SUCCESS;
	}

	public List<List<StatisticsVO>> getResult() {
		return result;
	}

	public void setResult(List<List<StatisticsVO>> result) {
		this.result = result;
	}

}

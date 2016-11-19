/**
 * 
 */
package com.ccl.action.mycourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.service.impl.MyCourseService;

/**
 *
 * @author 霄汉
 * @since 2016年3月23日 上午8:50:24
 * @version 1.0
 */
@Controller
public class GetExcelAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4505427403498315661L;

	@Autowired
	private MyCourseService service;
	
	private String result;
	
	public String execute() {
		result = service.getExcel();
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

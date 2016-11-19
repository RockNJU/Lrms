/**
 * 
 */
package com.ccl.action.semester;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;
import com.ccl.model.Semester;
import com.ccl.service.SemesterService;
import com.ccl.vo.SemesterVO;

import net.sf.json.JSONArray;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 上午11:38:33
 * @version 1.0
 */
@Controller
public class GetSemesterAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4750723528512042163L;

	@Autowired
	private SemesterService service;
	
	private JSONArray result;
	
	public String execute() {
		result = new JSONArray();
		List<Semester> ss = service.getSemesters();
		for (Semester s : ss) {
			result.add(new SemesterVO(s));
		}
		return SUCCESS;
	}

	public JSONArray getResult() {
		return result;
	}

	public void setResult(JSONArray result) {
		this.result = result;
	}

}

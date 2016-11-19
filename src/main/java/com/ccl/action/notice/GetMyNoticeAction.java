/**
 * 
 */
package com.ccl.action.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.model.Notice;
import com.ccl.service.MyNoticeService;

import net.sf.json.JSONArray;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 上午9:30:54
 * @version 1.0
 */
@Controller
public class GetMyNoticeAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -568705628524408998L;

	@Autowired
	private MyNoticeService service;
	
	private List<Notice> result;
	
	public String execute() {
		String uid = Utility.getUser(request).getUid();
		result = service.getMyNotice(uid);
		return SUCCESS;
	}

	public List<Notice> getResult() {
		return result;
	}

	public void setResult(List<Notice> result) {
		this.result = result;
	}

}

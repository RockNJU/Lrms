/**
 * 
 */
package com.ccl.action.teachcourse;

import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;

/**
 *
 * @author 霄汉
 * @since 2016年3月22日 下午9:35:55
 * @version 1.0
 */
@Controller
public class AssistManagePageAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5485972132502559889L;
	private int cid;
	
	public String execute() {
		
		setCid(Integer.parseInt(request.getParameter("cid")));
		return SUCCESS;
		
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

}

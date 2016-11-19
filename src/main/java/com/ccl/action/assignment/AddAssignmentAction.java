/**
 * 
 */
package com.ccl.action.assignment;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.model.Assignment;
import com.ccl.service.AssignmentService;
import com.ccl.service.NoticeService;

/**
 *
 * @author 霄汉
 * @since 2016年3月20日 上午8:53:31
 * @version 1.0
 */
@Controller
public class AddAssignmentAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4726665445585140062L;

	@Autowired
	private AssignmentService service;
	@Autowired
	private NoticeService noticeService;
	
	private String result;
	
	private Assignment assignment;
	
	private int aid;
	
	private String fid;
	
	public String execute() {
		
			
		int cid = Integer.parseInt(request.getParameter("cid"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String possibility = request.getParameter("possibility");
		String impact = request.getParameter("impact");
		String trig = request.getParameter("trig");
		String[] followers = request.getParameter("followers").split("-");
		
		Assignment ass = new Assignment();
		ass.setTitle(title);
		ass.setCreatedAt(new Date());
		ass.setContent(content);
		ass.setImpact(impact);
		ass.setPossibility(possibility);
		ass.setSubmitUid(Utility.getUser(request).getUid());
		ass.setTrig(trig);
		
		boolean flag = service.addAssignment(ass, cid, followers);
		if (flag) {
			setResult("success");
			noticeService.sendAssignmentNotice(cid);
		}else {
			setResult("fail");
		}
		return SUCCESS;

	}
	
	public String updateAssignmentInf(){
		
		if(assignment!=null&&assignment.getAssignmentid()!=0){
			Assignment ass=service.getAssignment(assignment.getAssignmentid());
			
			if(ass!=null){
				ass.setContent(assignment.getContent());
				ass.setImpact(assignment.getImpact());
				ass.setPossibility(assignment.getPossibility());
				ass.setTitle(assignment.getTitle());
				ass.setTrig(assignment.getTrig());
				service.updateAssignment(ass);
				setResult("success");
			}else{
				setResult("fail");
			}
		}else{
			setResult("error");
		}
		
		return SUCCESS;
	}
	
	public String addFollow(){
		boolean flag=service.addFollow(aid, fid);
		if(flag){
			setResult("success");
		}else{
			setResult("fail");
		}
		return SUCCESS;
	}
	
	public String delFollow(){
		
		if(Utility.getUser(request).getUid().equals(fid)){
			setResult("fail_self");
			return SUCCESS;
		}
		assignment=service.getAssignment(aid);
		if(assignment==null){
			setResult("fail_assignment_null");
			return SUCCESS;
		}
		if(assignment.getSubmitUid().equals(fid)){
			setResult("fail_creator");
			return SUCCESS;
		}
		boolean flag=service.delFollow(aid, fid);
		if(flag){
			setResult("success");
		}else{
			setResult("fail");
		}
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public AssignmentService getService() {
		return service;
	}

	public void setService(AssignmentService service) {
		this.service = service;
	}

	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

}

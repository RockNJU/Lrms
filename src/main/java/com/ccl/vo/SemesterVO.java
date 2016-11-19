/**
 * 
 */
package com.ccl.vo;

import com.ccl.Utility;
import com.ccl.model.Semester;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 下午5:04:52
 * @version 1.0
 */
public class SemesterVO {
	
	private String semestername;
	private String startDate;
	private String endDate;
	private String comment;
	
	public SemesterVO(Semester s) {
		this.semestername = s.getSemestername();
		this.startDate = Utility.formatDate(s.getStartDate());
		this.endDate = Utility.formatDate(s.getEndDate());
		this.comment = s.getComment();
	}

	public String getSemestername() {
		return semestername;
	}

	public void setSemestername(String semestername) {
		this.semestername = semestername;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

/**
 * 
 */
package com.ccl.vo;

/**
 *
 * @author 霄汉
 * @since 2016年3月20日 下午2:00:03
 * @version 1.0
 */
public class SubmissionInfoVO {
	
	private int assignmentid;
	private String title;
	private double point;
	private String description;
	private String deadline;
	private String submited;
	private String directionPath;
	private String reviewPath;
	private boolean isOver;
	
	public int getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(int assignmentid) {
		this.assignmentid = assignmentid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getSubmited() {
		return submited;
	}
	public void setSubmited(String submited) {
		this.submited = submited;
	}
	public boolean getIsOver() {
		return isOver;
	}
	public void setIsOver(boolean isOver) {
		this.isOver = isOver;
	}
	public String getDirectionPath() {
		return directionPath;
	}
	public void setDirectionPath(String directionPath) {
		this.directionPath = directionPath;
	}
	public String getReviewPath() {
		return reviewPath;
	}
	public void setReviewPath(String reviewPath) {
		this.reviewPath = reviewPath;
	}

}

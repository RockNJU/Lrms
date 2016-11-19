/**
 * 
 */
package com.ccl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *	每份风险评分
 * @author 霄汉
 * @since 2016年3月6日 上午11:07:20
 * @version 1.0
 */
@Entity
@Table(name="mark")
public class Mark implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6264918449746332160L;
	@Id
	private int assignmentid;
	@Id
	private String uid;
	private double mark;	//评分
	private Date createdAt;
	private String comment;	//备注
	public int getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(int assignmentid) {
		this.assignmentid = assignmentid;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

}

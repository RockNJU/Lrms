/**
 * 
 */
package com.ccl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *	风险安排
 * @author 霄汉
 * @since 2016年3月6日 上午10:48:20
 * @version 1.0
 */
@Entity
@Table(name="assignment")
public class Assignment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8108153576116602013L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int assignmentid;
	private Date createdAt;
	private String title;
	private String content;
	private String possibility;
	private String impact;
	private String trig;
	private String submitUid;
	public int getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(int assignmentid) {
		this.assignmentid = assignmentid;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPossibility() {
		return possibility;
	}
	public void setPossibility(String possibility) {
		this.possibility = possibility;
	}
	public String getImpact() {
		return impact;
	}
	public void setImpact(String impact) {
		this.impact = impact;
	}
	public String getTrig() {
		return trig;
	}
	public void setTrig(String trigger) {
		this.trig = trigger;
	}
	public String getSubmitUid() {
		return submitUid;
	}
	public void setSubmitUid(String submitUid) {
		this.submitUid = submitUid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


}

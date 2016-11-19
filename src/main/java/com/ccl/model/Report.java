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
 *	一次风险的总体报告，包括总结和每份风险的评分
 * @author 霄汉
 * @since 2016年3月6日 上午11:21:01
 * @version 1.0
 */
@Entity
@Table(name="report")
public class Report implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7202560964819303397L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int reportid;
	private int assignmentid;	//对应风险id
	private Date createdAt;
	private String stateDesc;
	private String content;	//报告内容	
	private String uid;
	public int getReportid() {
		return reportid;
	}
	public void setReportid(int reportid) {
		this.reportid = reportid;
	}
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
	public String getStateDesc() {
		return stateDesc;
	}
	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

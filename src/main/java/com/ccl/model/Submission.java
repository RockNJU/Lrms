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
 *	风险提交物
 * @author 霄汉
 * @since 2016年3月6日 上午10:40:32
 * @version 1.0
 */
@Entity
@Table(name="submission")
public class Submission implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -960371470753645220L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int submissionid;
	private String uid;
	private int assignmentid;
	private Date submitTime;
	private String format;	//格式，不包括点，如pdf, doc。如果没有扩展名，则为空字符串""
	private String path;	//在服务器上存储的位置
	public int getSubmissionid() {
		return submissionid;
	}
	public void setSubmissionid(int submissionid) {
		this.submissionid = submissionid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Date getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(int assignmentid) {
		this.assignmentid = assignmentid;
	}
	
}

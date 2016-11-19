/**
 * 
 */
package com.ccl.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 霄汉
 * @since 2016年3月6日 上午10:22:24
 * @version 1.0
 */
@Entity
@Table(name="schedule")
public class Schedule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5454825141873697943L;
	@Id
	private int cid;
	private int semesterid;
	private String comment;	//备注
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getSemesterid() {
		return semesterid;
	}
	public void setSemesterid(int semesterid) {
		this.semesterid = semesterid;
	}
	

}

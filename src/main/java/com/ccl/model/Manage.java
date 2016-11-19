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
 *
 * @author 霄汉
 * @since 2016年3月6日 上午10:19:11
 * @version 1.0
 */
@Entity
@Table(name="manage")
public class Manage implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8022499462441606051L;
	@Id
	private int cid;
	@Id
	private int assignmentid;
	private Date createdAt;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}

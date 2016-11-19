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
@Table(name="follow")
public class Follow implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -465089429879911020L;
	/**
	 * 
	 */

	@Id
	private int assignmentid;
	@Id
	private String uid;
	private Date createdAt;
	public int getAssignmentid() {
		return assignmentid;
	}
	public void setAssignmentid(int assignmentid) {
		this.assignmentid = assignmentid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	

}

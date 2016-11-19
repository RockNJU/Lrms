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
 * @since 2016年3月6日 上午10:15:29
 * @version 1.0
 */
@Entity
@Table(name="teach")
public class Teach implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2342721839797037415L;
	@Id
	private int cid;
	@Id
	private String uid;
	private Date createdAt;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTid() {
		return uid;
	}
	public void setTid(String tid) {
		this.uid = tid;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
	

}

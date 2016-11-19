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
 * @since 2016年3月6日 上午10:08:51
 * @version 1.0
 */
@Entity
@Table(name="selection")
public class Selection implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1517123786665860605L;
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
	public String getUid() {
		return uid;
	}
	public void setUid(String sid) {
		this.uid = sid;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date selectTime) {
		this.createdAt = selectTime;
	}

}

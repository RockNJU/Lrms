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
 *	总评
 * @author 霄汉
 * @since 2016年3月6日 上午11:39:58
 * @version 1.0
 */
@Entity
@Table(name="totalscore")
public class TotalScore implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1041288221770389014L;
	@Id
	private int uid;
	@Id
	private int cid;
	private int score;
	private Date createdAt;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}

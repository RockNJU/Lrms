/**
 * 
 */
package com.ccl.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 上午9:23:54
 * @version 1.0
 */
@Entity
@Table(name="notice")
public class Notice {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int noticeid;
	private String uid;
	private int cid;
	private String content;
	private Date uptoDate;
	
	public int getNoticeid() {
		return noticeid;
	}
	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getUptoDate() {
		return uptoDate;
	}
	public void setUptoDate(Date uptoDate) {
		this.uptoDate = uptoDate;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

}

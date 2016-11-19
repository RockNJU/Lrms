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
 * @since 2016年3月6日 上午9:48:01
 * @version 1.0
 */
@Entity
@Table(name="teacher")
public class Teacher implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7108286181728664115L;
	@Id
	private String uid;
	private String title;	//职称
	private boolean isAdmin;	//该教师是不是管理员
	private boolean isDirector;	//该教师是不是教学负责人
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean getIsDirector() {
		return isDirector;
	}
	public void setIsDirector(boolean isDirector) {
		this.isDirector = isDirector;
	}
	
}

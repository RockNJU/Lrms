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
 *
 * @author 霄汉
 * @since 2016年3月6日 上午9:58:58
 * @version 1.0
 */
@Entity
@Table(name="course")
public class Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6605714576508026645L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int cid;
	private String coursename;
	private int semesterid;
	private int credit;	//学分数
	private String description;	//项目描述
	private int state;	//0尚未开始  1正在进行 2已经结束
	private Date createdAt;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getState() {
		return 1;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getSemesterid() {
		return semesterid;
	}
	public void setSemesterid(int semesterid) {
		this.semesterid = semesterid;
	}
	

}

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
 * @since 2016年3月7日 下午2:08:41
 * @version 1.0
 */
@Entity
@Table(name="semester")
public class Semester implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8551193330266724943L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int semesterid;
	private String semestername;
	private Date startDate;
	private Date endDate;
	private String comment;
	
	public int getSemesterid() {
		return semesterid;
	}
	public void setSemesterid(int semesterid) {
		this.semesterid = semesterid;
	}
	public String getSemestername() {
		return semestername;
	}
	public void setSemestername(String semestername) {
		this.semestername = semestername;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}

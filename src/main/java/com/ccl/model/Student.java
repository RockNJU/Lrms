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
 * @since 2016年3月5日 下午5:45:27
 * @version 1.0
 */
@Entity
@Table(name="student")
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9116431761512462547L;
	@Id
	private String uid;
	private int enrollment;	//入学年份,即哪一级
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}
}

/**
 * 
 */
package com.ccl.service;

import java.util.List;

import com.ccl.model.Semester;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 上午11:40:27
 * @version 1.0
 */
public interface SemesterService {
	
	public List<Semester> getSemesters();
	
	public boolean addSemester(Semester semester);

}

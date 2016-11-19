/**
 * 
 */
package com.ccl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ccl.model.Assist;
import com.ccl.model.Course;
import com.ccl.model.Selection;
import com.ccl.model.Student;
import com.ccl.model.Teach;
import com.ccl.model.Teacher;
import com.ccl.model.User;

/**
 * 
 * @author 霄汉
 * @since 2016年3月7日 下午3:01:15
 * @version 1.0
 */
public interface UserLoginService {
	
	public User login(String uid, String password);
	
	public void setErrorMessage(HttpServletRequest request);
	
	public Student getStudent(String uid);
	
	public Teacher getTeacher(String uid);
	
	public List<Teach> getUserAllTeach(String uid);
	
	public List<Assist> getUserAllAssist(String uid);
	
	public List<Selection> getUserAllSelection(String uid);
	
	
}

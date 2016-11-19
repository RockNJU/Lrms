/**
 * 
 */
package com.ccl.service;

import java.util.List;

import com.ccl.model.Student;
import com.ccl.model.Teacher;
import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月13日 下午12:47:52
 * @version 1.0
 */
public interface UserManageService {
	
	public boolean changeAuthority(String uid, boolean isDirector, boolean isAdmin);
	
	public boolean deleteUser(String uid);
	
	public List<User> getAllTeacherUser();
	
	public List<Teacher> getAllTeachers();
	
	public List<User> getAllStudentUser();
	
	public List<User> searchStudentUser(String key);
	
	public List<User> searchTeacherUser(String key);
	
	public Teacher getTeacher(String uid);
	public Student getStudent(String uid);
}

/**
 * 
 */
package com.ccl.dao;

import java.util.List;

import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月13日 上午10:59:22
 * @version 1.0
 */
public interface UserDao extends BaseDao<User>{
	
	public List<User> getAllTeacherUser();
	
	public List<User> getAllStudentUser();
	
	public List<User> searchTeacherUser(String key);
	
	public List<User> searchStudentUser(String key);
	
	public void deleteUser(String uid);
}

/**
 * 
 */
package com.ccl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.StudentDao;
import com.ccl.dao.TeacherDao;
import com.ccl.dao.UserDao;
import com.ccl.model.Student;
import com.ccl.model.Teacher;
import com.ccl.model.User;
import com.ccl.service.UserManageService;

/**
 *
 * @author 霄汉
 * @since 2016年3月13日 下午12:47:37
 * @version 1.0
 */
@Service
public class UserManageServiceImpl implements UserManageService{
	
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private StudentDao studentDao;
	
	
	@Override
	public boolean changeAuthority(String uid, boolean isDirector, boolean isAdmin) {
		try {
			Teacher teacher = teacherDao.findById(Teacher.class, uid);
			teacher.setIsAdmin(isAdmin);
			teacher.setIsDirector(isDirector);
			teacherDao.update(teacher);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@Transactional
	private boolean studentDelTx(String uid) {
		try {
			studentDao.delete(Student.class, uid);
			userDao.delete(User.class, uid);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	private boolean teacherDelTx(String uid) {
		try {
			teacherDao.delete(Teacher.class, uid);
			userDao.delete(User.class, uid);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserManageService#deleteUser(java.lang.String)
	 */
	@Override
	public boolean deleteUser(String uid) {
//		if (uid.charAt(0) == 'T') {
			return teacherDelTx(uid);
//		}else {
//			return studentDelTx(uid);
//		}
		
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserManageService#getAllTeacherUser()
	 */
	@Override
	public List<User> getAllTeacherUser() {
		return userDao.getAllTeacherUser();
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserManageService#getAllTeachers()
	 */
	@Override
	public List<Teacher> getAllTeachers() {
		return teacherDao.getAllList(Teacher.class);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserManageService#getAllStudentUser()
	 */
	@Override
	public List<User> getAllStudentUser() {
		return userDao.getAllStudentUser();
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserManageService#searchStudentUser(java.lang.String)
	 */
	@Override
	public List<User> searchStudentUser(String key) {
		return userDao.searchStudentUser(key);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserManageService#getTeacher(java.lang.String)
	 */
	@Override
	public Teacher getTeacher(String uid) {
		return teacherDao.findById(Teacher.class, uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserManageService#getStudent(java.lang.String)
	 */
	@Override
	public Student getStudent(String uid) {
		return studentDao.findById(Student.class, uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserManageService#searchTeacherUser(java.lang.String)
	 */
	@Override
	public List<User> searchTeacherUser(String key) {
		return userDao.searchTeacherUser(key);
	}

}

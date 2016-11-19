/**
 * 
 */
package com.ccl.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccl.Constants;
import com.ccl.dao.AssistDao;
import com.ccl.dao.SelectionDao;
import com.ccl.dao.StudentDao;
import com.ccl.dao.TeachDao;
import com.ccl.dao.TeacherDao;
import com.ccl.dao.UserDao;
import com.ccl.model.Assist;
import com.ccl.model.Selection;
import com.ccl.model.Student;
import com.ccl.model.Teach;
import com.ccl.model.Teacher;
import com.ccl.model.User;
import com.ccl.service.UserLoginService;

/**
 *
 * @author 霄汉
 * @since 2016年3月7日 下午3:28:24
 * @version 1.0
 */
@Service
public class UserLoginServiceImpl implements UserLoginService{
	
	@Autowired
	private UserDao userdao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private TeachDao teachDao;
	@Autowired
	private AssistDao assistDao;
	@Autowired
	private SelectionDao selectionDao;

	/* 成功true，失败false
	 * @see com.ccl.service.UserLoginService#login(com.ccl.model.User)
	 */
	@Override
	public User login(String uid, String password) {
		User user = userdao.findById(User.class, uid);
		if (user == null) return null;
		String rightpw = user.getPassword();
		if (rightpw == null || !rightpw.equals(password)) {
			return null;
		}else {
			return user;
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserLoginService#sendErrorMessage(javax.servlet.ServletRequest)
	 */
	@Override
	public void setErrorMessage(HttpServletRequest request) {
		request.setAttribute("errorMessage", Constants.LOGIN_ERROR_MESSAGE);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserLoginService#getStudent(java.lang.String)
	 */
	@Override
	public Student getStudent(String uid) {
		return studentDao.findById(Student.class, uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserLoginService#getTeacher(java.lang.String)
	 */
	@Override
	public Teacher getTeacher(String uid) {
		return teacherDao.findById(Teacher.class, uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserLoginService#getUserAllTeach(java.lang.String)
	 */
	@Override
	public List<Teach> getUserAllTeach(String uid) {
		return teachDao.getListByColumn(Teach.class, "uid", uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserLoginService#getUserAllAssist(java.lang.String)
	 */
	@Override
	public List<Assist> getUserAllAssist(String uid) {
		return assistDao.getListByColumn(Assist.class, "uid", uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserLoginService#getUserAllSelection(java.lang.String)
	 */
	@Override
	public List<Selection> getUserAllSelection(String uid) {
		return selectionDao.getListByColumn(Selection.class, "uid", uid);
	}

}

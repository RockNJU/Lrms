/**
 * 
 */
package com.ccl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccl.dao.UserDao;
import com.ccl.model.User;
import com.ccl.service.UserInfoService;

/**
 *
 * @author 霄汉
 * @since 2016年3月8日 下午3:28:29
 * @version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see com.ccl.service.UserInfoService#changePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean changePassword(String uid, String oldPw, String newPw) {
		User result = userDao.findById(User.class, uid);
		if (result == null) return false;
		String rightPw = result.getPassword();
		if (rightPw.equals(oldPw)) {
			result.setPassword(newPw);
			userDao.update(result);
			return true;
		}else {
			return false;
		}
	}



	/* (non-Javadoc)
	 * @see com.ccl.service.UserInfoService#updateUserInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateUserInfo(String uid, String email, String tel) {
		User result = userDao.findById(User.class, uid);
		if (result == null) return false;
		result.setEmail(email);
		result.setTel(tel);
		userDao.update(result);
		return true;
	}



	/* (non-Javadoc)
	 * @see com.ccl.service.UserInfoService#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String uid) {
		return userDao.findById(User.class, uid);
	}




}

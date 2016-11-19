/**
 * 
 */
package com.ccl.service;

import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月7日 下午9:21:14
 * @version 1.0
 */
public interface UserInfoService {
	
	public boolean updateUserInfo(String uid, String email, String tel);
	
	public boolean changePassword(String uid, String oldPw, String newPw);
	
	public User getUser(String uid);
	

}

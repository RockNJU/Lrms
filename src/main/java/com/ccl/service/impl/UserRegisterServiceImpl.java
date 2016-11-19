/**
 * 
 */
package com.ccl.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.JWStub;
import com.ccl.dao.BaseDao;
import com.ccl.model.Student;
import com.ccl.model.Teacher;
import com.ccl.model.User;
import com.ccl.service.UserRegisterService;

/**
 *
 * @author 霄汉
 * @since 2016年3月10日 下午9:16:02
 * @version 1.0
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService{
		
	@Autowired
	private BaseDao<User> userDao;
	@Autowired
	private BaseDao<Student> studentDao;
	@Autowired
	private BaseDao<Teacher> teacherDao;

	/* (non-Javadoc)
	 * @see com.ccl.service.UserRegisterService#register(java.util.ArrayList)
	 */
	@Override
	public String register(ArrayList<String> uids) {
		StringBuffer sb = new StringBuffer();
		for (String uid : uids) {
			User user = JWStub.lookupUser(uid);
			if (user == null) {
				sb.append(uid + "注册失败：工号不合法。");
			}else {
				
				Teacher teacher = JWStub.lookupTeacher(uid);
				teacherTx(sb, teacher, user);
				//}else {
					//Student student = JWStub.lookupStudent(uid);
				//	studentTx(sb, student, user);
				//}
			}
		}
		if (sb.length() == 0) {
			sb.append("注册成功！");
		}
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserRegisterService#batchRegister(java.lang.String, java.lang.String)
	 */
	@Override
	public String batchRegister(String start, String end) {
		if (start.length() != end.length()) {
			return "注册失败：无法解析工号规律。";
		}
		int numPrefix = 0;
		for (numPrefix = 0; numPrefix < start.length(); numPrefix ++) {
			if (start.charAt(numPrefix) != end.charAt(numPrefix)) {
				break;
			}
		}
		ArrayList<String> ids = new ArrayList<String>();
		if (numPrefix == start.length()) {
			ids.add(start);
			return register(ids);
		}else {
			String prefix = start.substring(0, numPrefix);
			int remainDigits = start.length() - numPrefix;
			String startRemain = start.substring(numPrefix);
			String endRemain = end.substring(numPrefix);
			if (startRemain.length() > 3) {
				return "注册失败：无法解析工号规律。";
			}else {
				int startInt;
				int endInt;
				try {
					startInt = Integer.parseInt(startRemain);
					endInt = Integer.parseInt(endRemain);
				}catch (Exception e) {
					return "注册失败：无法解析工号规律。";
				}
				for (int k=startInt;k<=endInt;k++) {
					String remain = String.format("%0" + remainDigits + "d", k);
					ids.add(prefix + remain);
				}
				return register(ids);
			}
		}
	}

//	@Transactional
//	private void studentTx(StringBuffer sb, Student student, User user) {
//		try {
//			studentDao.save(student);
//			userDao.save(user);
//		}catch (Exception e) {
//			sb.append(user.getUid() + "注册失败：该学号已存在。");
//		}
//	}
	
	@Transactional
	private void teacherTx(StringBuffer sb, Teacher teacher, User user) {
		try {
			teacherDao.save(teacher);
			userDao.save(user);
		}catch (Exception e) {
			sb.append(user.getUid() + "注册失败：该工号已存在。");
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.UserRegisterService#registerAdmin()
	 */
	@Override
	public void registerAdmin() {
		User adm = new User();
		adm.setBirthday(new Date());
		adm.setCreatedAt(new Date());
		adm.setGender(0);
		adm.setPassword("admin");
		adm.setUid("admin");
		adm.setUsername("admin");
		adm.setUserType(0);
		userDao.save(adm);
		
		Teacher t = new Teacher();
		t.setIsAdmin(true);
		t.setIsDirector(true);
		t.setTitle("admin");
		t.setUid("admin");
		teacherDao.save(t);
	}
	
	

}

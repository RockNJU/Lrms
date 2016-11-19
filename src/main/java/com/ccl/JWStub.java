/**
 * 
 */
package com.ccl;

import java.sql.Date;
import java.util.Calendar;

import com.ccl.model.Student;
import com.ccl.model.Teacher;
import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月10日 下午8:15:21
 * @version 1.0
 */
public class JWStub {
	
	private static final String [] FAMILY_NAMES = {"赵","钱","马","文","周","王","习","胡","温",
			"牛","杨","金"};
	
	private static final String [] LAST_NAMES = {"三胖","富贵","建国","洪波","煊义","志军","云","彦宏",
			"婧","思思","心蓓","波","云迪","梦雨","潇涵","薇薇","淑怡","呦呦","馨予"};
	
	private static final String [] TITLES = {"讲师","教授","副教授"};
	
	public static User lookupUser(String uid) {
		User user = new User();
		if (uid == null || uid.equals("null") || uid.equals("\"null\"") || uid.length() < 3) return null;
		int hash = uid.hashCode();
		if (hash == Integer.MIN_VALUE) {
			hash = 0;
		}
		else if (hash < 0) {
			hash = - hash;
		}
		String name = FAMILY_NAMES[hash % 12] + LAST_NAMES[hash % 19];
		user.setUsername(name);
		int ageOff = hash % 5;
		Calendar c = Calendar.getInstance();
//		if (uid.charAt(0) == 'T') {
				c.set(1980 + ageOff, hash % 11, hash % 28);
				user.setUserType(0);
	//		}else {
		//		c.set(1993 + ageOff, hash % 11, hash % 28);
			//	user.setUserType(1);
			//}
			user.setBirthday(new Date(c.getTimeInMillis()));
			user.setCreatedAt(new Date(c.getTimeInMillis()));
			user.setGender(hash % 2);
		
		user.setPassword(uid);
		user.setUid(uid);
		return user;
	}
	
	public static Teacher lookupTeacher(String uid) {
		Teacher teacher = new Teacher();
		teacher.setUid(uid);
		teacher.setIsAdmin(false);
		teacher.setIsDirector(false);
		int titleIndex = Math.abs(uid.hashCode()) % 3;
		teacher.setTitle(TITLES[titleIndex]);
		return teacher;
	}
	
	public static Student lookupStudent(String uid) {
		Student student = new Student();
		student.setUid(uid);
		int enroll;
		try {
			enroll = Integer.parseInt(uid.substring(0,2));
		}catch(Exception e) {
			try {
				enroll = Integer.parseInt(uid.substring(2,4));
			}catch(Exception ex) {
				enroll = (int)(Math.random()*9);
			}
		}
		student.setEnrollment(enroll);
		return student;
	}

}

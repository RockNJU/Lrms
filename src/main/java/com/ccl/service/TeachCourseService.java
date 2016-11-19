/**
 * 
 */
package com.ccl.service;

import java.util.ArrayList;
import java.util.List;

import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午3:27:31
 * @version 1.0
 */
public interface TeachCourseService {
	
	public List<User> getStudentsToAttend(int cid);
	
	public List<User> getAttendStudents(int cid);
	
	public String selectCourse(int cid, ArrayList<String> uids);
	
	public String batchSelectCourse(int cid, String startUid, String endUid);
	
	public void delSelection(int cid, String uid);
	
	
	
	
	public List<User> getStudentsToAssist(int cid);
	
	public List<User> getAssistStudents(int cid);
	
	public String assistCourse(int cid, ArrayList<String> uids);
	
	public void delAssist(int cid, String uid);
	
	
	
	public boolean approveReport(int reportid);
	
	public boolean disproveReport(int reportid);

}

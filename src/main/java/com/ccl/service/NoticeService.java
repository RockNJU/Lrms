/**
 * 
 */
package com.ccl.service;

/**
 *
 * @author 霄汉
 * @since 2016年3月23日 上午12:14:15
 * @version 1.0
 */
public interface NoticeService {
	
	public void sendStudentNotice(int cid, String uid);
	
	public void sendTeacherNotice(int cid, String uid);
	
	public void sendAssistNotice(int cid, String uid);
	
	public void sendAssignmentNotice(int cid);

}

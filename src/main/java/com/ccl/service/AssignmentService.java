/**
 * 
 */
package com.ccl.service;

import java.util.Date;
import java.util.List;

import com.ccl.model.Assignment;
import com.ccl.model.Mark;
import com.ccl.model.Report;
import com.ccl.model.Submission;
import com.ccl.model.User;
import com.ccl.vo.StatisticsVO;
import com.ccl.vo.SubmissionInfoVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月20日 下午2:02:48
 * @version 1.0
 */
public interface AssignmentService {
	
	public List<User> getUserInProject(int cid);
	
	
	public boolean addAssignment(Assignment assignment, int cid, String[] followers);
	
	public void delAssignment(int assignmentid);

	public void updateAssignment(Assignment assignment);
	
	public Assignment getAssignment(int aid);
	
	public List<Assignment> getAssignments(int cid);
	
	public List<SubmissionInfoVO> getSubmissionInfo(int cid, String uid);
	
	
	public void writeSubmissionRecord(Submission submission);
	
	
	
	public List<Mark> getMarks(int assignmentid);
	
	public Report getReport(int assignmentid);
	
	public void writeMarks(List<Mark> marks);
	
	
	
	
	public void writeReport(Report report);
	
	public List<Report> getReports(int assignmentid);
	
	public List<User> getFollowsByAssignmentid(int assignmentid);
	
	public boolean addFollow(int aid, String fid);
	
	public boolean delFollow(int aid, String fid);
	
	public boolean isFollower(String uid, int assignmentid);
	
	
	
	public List<Assignment> getAssignmentToImport(int cid);
	
	public List<StatisticsVO> getRecomendRecoAssignmentToImport(Date start, Date end, int cid);
	
	public List<StatisticsVO> getRecomendProbAssignmentToImport(Date start, Date end, int cid);
	
	public void importAssignment(int cid, int assignmentid);


}

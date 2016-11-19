/**
 * 
 */
package com.ccl.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccl.dao.AssignmentDao;
import com.ccl.dao.FollowDao;
import com.ccl.dao.ManageDao;
import com.ccl.dao.MarkDao;
import com.ccl.dao.ReportDao;
import com.ccl.dao.SelectionDao;
import com.ccl.dao.SubmissionDao;
import com.ccl.model.Assignment;
import com.ccl.model.Follow;
import com.ccl.model.Manage;
import com.ccl.model.Mark;
import com.ccl.model.Report;
import com.ccl.model.Selection;
import com.ccl.model.Submission;
import com.ccl.model.User;
import com.ccl.service.AssignmentService;
import com.ccl.vo.StatisticsVO;
import com.ccl.vo.SubmissionInfoVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月20日 下午2:04:06
 * @version 1.0
 */
@Service
public class AssignmentServiceImpl implements AssignmentService{
	
	@Autowired
	private AssignmentDao assignmentDao;
	@Autowired
	private SubmissionDao submissionDao;
	@Autowired
	private MarkDao markDao;
	@Autowired
	private ReportDao reportDao;
	@Autowired
	private FollowDao followDao;
	@Autowired
	private SelectionDao selectionDao;
	@Autowired
	private ManageDao manageDao;

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#addAssignment(com.ccl.model.Assignment)
	 */
	@Override
	public boolean addAssignment(Assignment assignment, int cid,  String[] followers) {
		try {
			assignmentDao.save(assignment);
			//cid == -1表示发布尚不属于任何RA的风险
			if (cid != -1) {
				manageDao.addManage(cid, assignment.getAssignmentid());
			}
			int aid = assignment.getAssignmentid();
			for (String fid : followers) {
				Follow follow = new Follow();
				follow.setAssignmentid(aid);
				follow.setCreatedAt(new Date());
				follow.setUid(fid);
				followDao.save(follow);
			}
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#delAssignment(int)
	 */
	@Override
	public void delAssignment(int assignmentid) {
		assignmentDao.delete(Assignment.class, assignmentid);
		
	}
	
	@Override
	public void updateAssignment(Assignment assignment){
		assignmentDao.update(assignment);
	}
	
	@Override
	public Assignment getAssignment(int aid){
		return assignmentDao.findById(Assignment.class, aid);
	}
	
	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#getAssignments(int)
	 */
	@Override
	public List<Assignment> getAssignments(int cid) {
		if (cid == -1) {
			return assignmentDao.getAllList(Assignment.class);
		}
		else {
			return manageDao.getAssignmentsByCid(cid);
		}

	}

	/* (non-Javadoc)
	 * @see com.ccl.service.AssignmentService#getSubmissionInfo(int, java.lang.String)
	 */
	@Override
	public List<SubmissionInfoVO> getSubmissionInfo(int cid, String uid) {
		return assignmentDao.getSubmissionInfo(cid, uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.AssignmentService#writeSubmissionRecord(com.ccl.model.Submission)
	 */
	@Override
	public void writeSubmissionRecord(Submission submission) {
		submissionDao.overwriteSubmissionRecord(submission);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.AssignmentService#getMarks(int)
	 */
	@Override
	public List<Mark> getMarks(int assignmentid) {
		return markDao.getAllMarks(assignmentid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.AssignmentService#getReport(int)
	 */
	@Override
	public Report getReport(int assignmentid) {
		return reportDao.findByColumn(Report.class, "assignmentid", assignmentid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.AssignmentService#writeMarks(java.util.List)
	 */
	@Override
	public void writeMarks(List<Mark> marks) {
		for (Mark m : marks) {
			markDao.overwriteMark(m);
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.AssignmentService#writeReport(com.ccl.model.Report)
	 */
	@Override
	public void writeReport(Report report) {
		reportDao.save(report);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.AssignmentService#getUserInProject(int)
	 */
	@Override
	public List<User> getUserInProject(int cid) {
		List<User> users = selectionDao.getAttendUserByCid(cid);
		return users;
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.AssignmentService#getReports(int)
	 */
	@Override
	public List<Report> getReports(int assignmentid) {
		return reportDao.getListByColumn(Report.class, "assignmentid", assignmentid);
		
	}
	
	@Override
	public List<User> getFollowsByAssignmentid(int assignmentid){
		return followDao.getFollowUserByAssignmentid(assignmentid);
	}
	
	@Override
	public boolean addFollow(int aid, String fid){
		
		
		Follow fol=followDao.getFollowByAssignmentidAndUid(aid, fid);
		boolean flag=false;
		if(fol==null){
			flag=followDao.addFollow(aid, fid);
			if(flag){
				List<Integer> cidList=manageDao.getCourseIdByAssignemntId(aid);
				for(int i=0;i<cidList.size();i++){
					Selection s=selectionDao.getSelectionByCidAndUid(cidList.get(i), fid);
					if(s==null){
						selectionDao.addSelection(cidList.get(i), fid);
					}
				}
			}
		}else{
			flag=true;
		}
		return flag;
	}
	
	@Override
	public boolean delFollow(int aid, String fid){
		Follow fol=followDao.getFollowByAssignmentidAndUid(aid, fid);
		if(fol!=null){
			followDao.delete(fol);
		}
		return true;
	}
	

	/* (non-Javadoc)
	 * @see com.ccl.service.AssignmentService#isFollower(java.lang.String, int)
	 */
	@Override
	public boolean isFollower(String uid, int assignmentid) {
		List<User> followers = followDao.getFollowUserByAssignmentid(assignmentid);
		boolean isFollower = false;
		for (User user : followers) {
			if (user.getUid().equals(uid)) {
				isFollower = true;
				break;
			}
		}
		return isFollower;
	}

	@Override
	public List<Assignment> getAssignmentToImport(int cid) {
		return manageDao.getAssignmentsToImportByCid(cid);
	}

	@Override
	public List<StatisticsVO> getRecomendRecoAssignmentToImport(Date start, Date end, int cid) {
		List<Report> reports = manageDao.getReportsExceptGivenCid(cid);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Report r : reports) {
			if (r.getCreatedAt().before(end) && r.getCreatedAt().after(start)) {
				if (!map.containsKey(r.getAssignmentid())) {
					map.put(r.getAssignmentid(), 0);
				}
				map.put(r.getAssignmentid(), map.get(r.getAssignmentid()) + 1);
			}
		}
		List<StatisticsVO> stats = new ArrayList<StatisticsVO>();
		for (Entry<Integer, Integer> e : map.entrySet()) {
			int assignmentid = e.getKey();
			stats.add(new StatisticsVO(assignmentDao.findById(Assignment.class, assignmentid), e.getValue()));
		}
		Collections.sort(stats, new Comparator<StatisticsVO>(){
			public int compare(StatisticsVO v1, StatisticsVO v2) {
				return v2.count - v1.count;
			}
		});

		if (stats.size() <= 5) {
			return stats;
		}
		else {
			return stats.subList(0, 5);
		}
	}

	@Override
	public List<StatisticsVO> getRecomendProbAssignmentToImport(Date start, Date end, int cid) {
		List<Report> reports = manageDao.getReportsExceptGivenCid(cid);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Report r : reports) {
			if (r.getCreatedAt().before(end) && r.getCreatedAt().after(start) && r.getStateDesc().equals("问题")) {
				if (!map.containsKey(r.getAssignmentid())) {
					map.put(r.getAssignmentid(), 0);
				}
				map.put(r.getAssignmentid(), map.get(r.getAssignmentid()) + 1);
			}
		}
		List<StatisticsVO> stats = new ArrayList<StatisticsVO>();
		for (Entry<Integer, Integer> e : map.entrySet()) {
			int assignmentid = e.getKey();
			stats.add(new StatisticsVO(assignmentDao.findById(Assignment.class, assignmentid), e.getValue()));
		}
		Collections.sort(stats, new Comparator<StatisticsVO>(){
			public int compare(StatisticsVO v1, StatisticsVO v2) {
				return v2.count - v1.count;
			}
		});

		if (stats.size() <= 5) {
			return stats;
		}
		else {
			return stats.subList(0, 5);
		}
	}

	@Override
	public void importAssignment(int cid, int assignmentid) {
		Manage m = new Manage();
		m.setAssignmentid(assignmentid);
		m.setCid(cid);
		m.setCreatedAt(new Date());
		manageDao.save(m);
		
		//此风险的跟踪者成为此RA的参与者
		List<User> followers = followDao.getFollowUserByAssignmentid(assignmentid);
		List<User> attend = selectionDao.getAttendUserByCid(cid);
		for (User f : followers) {
			boolean isAttend = false;
			for (User a : attend) {
				if (f.getUid().equals(a.getUid())) {
					isAttend = true;
					break;
				}
			}
			if (!isAttend) {
				selectionDao.addSelection(cid, f.getUid());
			}
		}
	}

}

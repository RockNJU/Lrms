/**
 * 
 */
package com.ccl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccl.dao.AssistDao;
import com.ccl.dao.ReportDao;
import com.ccl.dao.SelectionDao;
import com.ccl.dao.TeachDao;
import com.ccl.model.Report;
import com.ccl.model.Selection;
import com.ccl.model.Teach;
import com.ccl.model.User;
import com.ccl.service.TeachCourseService;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午3:46:13
 * @version 1.0
 */
@Service
public class TeachCourseServiceImpl implements TeachCourseService{
	
	@Autowired
	private SelectionDao selectionDao;
	@Autowired
	private ReportDao reportDao;
	@Autowired
	private TeachDao teachDao;
	@Autowired
	private AssistDao assistDao;

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#getAttendStudents(int)
	 */
	@Override
	public List<User> getAttendStudents(int cid) {
		return selectionDao.getAttendUserByCid(cid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#selectCourse(int, java.lang.String[])
	 */
	@Override
	public String selectCourse(int cid, ArrayList<String> uids) {
		StringBuffer sb = new StringBuffer();
		for (String uid : uids) {
			if (selectionDao.findByColumns(Selection.class, "cid", cid, "uid", uid) != null) {
				sb.append(uid + "添加失败：已经是该项目参与者。");
			}
			else {
				boolean flag = selectionDao.addSelection(cid, uid);
				if (!flag) {
					sb.append(uid + "添加失败。");
				}
			}
		}
		if (sb.length() == 0) {
			sb.append("添加成功!");
		}
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#batchSelectCourse(int, java.lang.String, java.lang.String)
	 */
	@Override
	public String batchSelectCourse(int cid, String start, String end) {
		if (start.length() != end.length()) {
			return "批量添加失败：无法解析工号规律。";
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
			return selectCourse(cid, ids);
		}else {
			String prefix = start.substring(0, numPrefix);
			int remainDigits = start.length() - numPrefix;
			String startRemain = start.substring(numPrefix);
			String endRemain = end.substring(numPrefix);
			if (startRemain.length() > 3) {
				return "添加失败：无法解析工号规律。";
			}else {
				int startInt;
				int endInt;
				try {
					startInt = Integer.parseInt(startRemain);
					endInt = Integer.parseInt(endRemain);
				}catch (Exception e) {
					return "添加失败：无法解析工号规律。";
				}
				for (int k=startInt;k<=endInt;k++) {
					String remain = String.format("%0" + remainDigits + "d", k);
					ids.add(prefix + remain);
				}
				return selectCourse(cid, ids);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#delSelection(int, java.lang.String)
	 */
	@Override
	public void delSelection(int cid, String uid) {
		selectionDao.deleteByColumns(Selection.class, "cid", cid, "uid", uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#getAssistStudents(int)
	 */
	@Override
	public List<User> getAssistStudents(int cid) {
		return assistDao.getAssistUserByCid(cid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#assistCourse(int, java.lang.String[])
	 */
	@Override
	public String assistCourse(int cid, ArrayList<String> uids) {
		StringBuffer sb = new StringBuffer();
		for (String uid : uids) {
			if (selectionDao.findByColumns(Selection.class, "cid", cid, "uid", uid) != null) {
				sb.append(uid + "添加失败：已经是该项目参与者。");
			}else {
				boolean flag = assistDao.addAssist(cid, uid);
				if (!flag) {
					sb.append(uid + "添加失败。");
				}
			}
		}
		if (sb.length() == 0) {
			sb.append("添加成功!");
		}
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#delAssist(int, java.lang.String)
	 */
	@Override
	public void delAssist(int cid, String uid) {
		assistDao.delAssist(cid, uid);
	}



	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#approveReport(int)
	 */
	@Override
	public boolean approveReport(int reportid) {
		try {
			Report report = reportDao.findById(Report.class, reportid);
//			report.setState(1);
			reportDao.update(report);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#disproveReport(int)
	 */
	@Override
	public boolean disproveReport(int reportid) {
		try {
			Report report = reportDao.findById(Report.class, reportid);
//			report.setState(2);
			reportDao.update(report);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#getStudentsToAttend(int)
	 */
	@Override
	public List<User> getStudentsToAttend(int cid) {
		return selectionDao.getUserToAttendByCid(cid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.TeachCourseService#getStudentsToAssist(int)
	 */
	@Override
	public List<User> getStudentsToAssist(int cid) {
		return assistDao.getUserToAssistByCid(cid);
	}

	
	
}

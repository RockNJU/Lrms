/**
 * 
 */
package com.ccl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.dao.CourseDao;
import com.ccl.dao.NoticeDao;
import com.ccl.dao.SelectionDao;
import com.ccl.model.Course;
import com.ccl.model.Notice;
import com.ccl.model.Selection;
import com.ccl.service.NoticeService;

/**
 *
 * @author 霄汉
 * @since 2016年3月23日 上午12:16:07
 * @version 1.0
 */
@Controller
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private SelectionDao selectionDao;
	@Autowired
	private CourseDao courseDao;

	/* (non-Javadoc)
	 * @see com.ccl.service.NoticeService#sendStudentNotice(int)
	 */
	@Override
	public void sendStudentNotice(int cid, String uid) {
		Course course = courseDao.findById(Course.class, cid);
		String name = course.getCoursename();
		Notice notice = new Notice();
		notice.setCid(cid);
		notice.setContent("您已经成为项目《" + name + "》的参与者！");
		notice.setUid(uid);
		notice.setUptoDate(new Date());
		noticeDao.save(notice);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.NoticeService#sendTeacherNotice(int)
	 */
	@Override
	public void sendTeacherNotice(int cid, String uid) {
		Course course = courseDao.findById(Course.class, cid);
		String name = course.getCoursename();
		Notice notice = new Notice();
		notice.setCid(cid);
		notice.setContent("您已经成为项目《" + name + "》的负责人！");
		notice.setUid(uid);
		notice.setUptoDate(new Date());
		noticeDao.save(notice);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.NoticeService#sendAssistNotice(int)
	 */
	@Override
	public void sendAssistNotice(int cid, String uid) {
		Course course = courseDao.findById(Course.class, cid);
		String name = course.getCoursename();
		Notice notice = new Notice();
		notice.setCid(cid);
		notice.setContent("您已经成为项目《" + name + "》的助教！");
		notice.setUid(uid);
		notice.setUptoDate(new Date());
		noticeDao.save(notice);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.NoticeService#sendAssignmentNotice(int)
	 */
	@Override
	public void sendAssignmentNotice(int cid) {
		Course course = courseDao.findById(Course.class, cid);
		if (course == null) return;
		String name = course.getCoursename();
		List<Selection> selections = selectionDao.getListByColumn(Selection.class, "cid", cid);
		for (Selection s : selections) {
			Notice notice = new Notice();
			notice.setCid(cid);
			notice.setContent("您的项目《" + name + "》有新的风险！");
			notice.setUid(s.getUid());
			notice.setUptoDate(new Date());
			noticeDao.save(notice);
		}
		
	}

}

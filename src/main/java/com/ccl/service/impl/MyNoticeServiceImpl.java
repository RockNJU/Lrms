/**
 * 
 */
package com.ccl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccl.dao.NoticeDao;
import com.ccl.model.Notice;
import com.ccl.service.MyNoticeService;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 上午9:32:58
 * @version 1.0
 */
@Service
public class MyNoticeServiceImpl implements MyNoticeService {
	
	@Autowired
	private NoticeDao noticeDao;

	/* (non-Javadoc)
	 * @see com.ccl.service.MyNoticeService#getMyNotice(java.lang.String)
	 */
	@Override
	public List<Notice> getMyNotice(String uid) {
		return noticeDao.getMyNotice(uid);
	}

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
}

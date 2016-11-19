/**
 * 
 */
package com.ccl.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.NoticeDao;
import com.ccl.model.Notice;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 上午9:28:01
 * @version 1.0
 */
@Repository
@Transactional
public class NoticeDaoImpl extends BaseDaoImpl<Notice> implements NoticeDao{

	/* (non-Javadoc)
	 * @see com.ccl.dao.NoticeDao#getMyNotice(java.lang.String)
	 */
	@Override
	public List<Notice> getMyNotice(String uid) {
		Session s = getNewSession();
		Criteria c = s.createCriteria(Notice.class);
		c.add(Restrictions.eq("uid", uid));
		@SuppressWarnings("unchecked")
		List<Notice> list = c.list();
		s.close();
		return list;
	}
	

}

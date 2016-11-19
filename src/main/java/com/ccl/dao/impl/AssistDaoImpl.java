/**
 * 
 */
package com.ccl.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.AssistDao;
import com.ccl.model.Assist;
import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午3:52:21
 * @version 1.0
 */
@Repository
@Transactional
public class AssistDaoImpl extends BaseDaoImpl<Assist> implements AssistDao{

	/* (non-Javadoc)
	 * @see com.ccl.dao.AssistDao#addAssist(int, java.lang.String)
	 */
	@Override
	public boolean addAssist(int cid, String uid) {
		try {
			Assist a = new Assist();
			a.setCid(cid);
			a.setUid(uid);
			a.setCreatedAt(new Date());
			save(a);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.AssistDao#delAssist(int, java.lang.String)
	 */
	@Override
	public void delAssist(int cid, String uid) {
		deleteByColumns(Assist.class, "cid", cid, "uid", uid);
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.AssistDao#getAssistUserByCid(int)
	 */
	@Override
	public List<User> getAssistUserByCid(int cid) {
		String sql = "select u from User u, Assist a where u.uid=a.uid and a.cid='"+cid+"'";
		@SuppressWarnings("unchecked")
		List<User> result = getSession().createQuery(sql).list();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.AssistDao#getUserToAssistByCid(int)
	 */
	@Override
	public List<User> getUserToAssistByCid(int cid) {
		String sql = "select u from User u where u.userType=1 and u.uid not in (select a.uid from Assist a where a.cid='"+cid+"')";
		@SuppressWarnings("unchecked")
		List<User> result = getSession().createQuery(sql).list();
		return result;
	}

}

/**
 * 
 */
package com.ccl.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.FollowDao;
import com.ccl.model.Follow;
import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午3:52:21
 * @version 1.0
 */
@Repository
@Transactional
public class FollowDaoImpl extends BaseDaoImpl<Follow> implements FollowDao{

	/* (non-Javadoc)
	 * @see com.ccl.dao.AssistDao#addAssist(int, java.lang.String)
	 */
	@Override
	public boolean addFollow(int assignmentid, String uid) {
		try {
			Follow a = new Follow();
			a.setAssignmentid(assignmentid);
			a.setUid(uid);
			a.setCreatedAt(new Date());
			save(a);
			return true;
		}catch (Exception e) {
			return false;
		}
	}


	/* (non-Javadoc)
	 * @see com.ccl.dao.AssistDao#getAssistUserByCid(int)
	 */
	@Override
	public List<User> getFollowUserByAssignmentid(int assignmentid) {
		String sql = "select u from User u, Follow a where u.uid=a.uid and a.assignmentid='"+assignmentid+"'";
		@SuppressWarnings("unchecked")
		List<User> result = getSession().createQuery(sql).list();
		return result;
	}
	
	@Override
	public Follow getFollowByAssignmentidAndUid(int assignmentid, String uid) {
		String sql = "select a from Follow a where a.uid='"+uid+"' and a.assignmentid='"+assignmentid+"'";
		@SuppressWarnings("unchecked")
		List<Follow> result = getSession().createQuery(sql).list();
		if(result==null||result.size()<=0){
			return null;
		}
		return result.get(0);
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.AssistDao#getUserToAssistByCid(int)
	 */
	@Override
	public List<User> getUserToFollowByAssignmentid(int assignmentid) {
		String sql = "select u from User u where u.uid not in (select a.uid from Follow a where a.assignmentid='"+assignmentid+"')";
		@SuppressWarnings("unchecked")
		List<User> result = getSession().createQuery(sql).list();
		return result;
	}

}

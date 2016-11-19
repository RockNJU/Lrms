/**
 * 
 */
package com.ccl.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.SelectionDao;
import com.ccl.model.Selection;
import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午4:14:05
 * @version 1.0
 */
@Repository
@Transactional
public class SelectionDaoImpl extends BaseDaoImpl<Selection> implements SelectionDao{

	/* (non-Javadoc)
	 * @see com.ccl.dao.SelectionDao#addSelection(int, java.lang.String)
	 */
	@Override
	public boolean addSelection(int cid, String uid) {
		try {
			Selection s = new Selection();
			s.setCid(cid);
			s.setUid(uid);
			s.setCreatedAt(new Date());
			save(s);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.SelectionDao#delSelection(int, java.lang.String)
	 */
	@Override
	public void delSelection(int cid, String uid) {
		deleteByColumns(Selection.class, "cid", cid, "uid", uid);
	}
	
	@Override
	public Selection getSelectionByCidAndUid(int cid, String uid){
		String sql = "select s from Selection s where s.cid="+cid+" and s.uid='"+uid+"'";
		@SuppressWarnings("unchecked")
		List<Selection> result = getSession().createQuery(sql).list();
		if(result==null||result.size()<=0){
			return null;
		}
		return result.get(0);
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.SelectionDao#getAttendUserByCid(int)
	 */
	@Override
	public List<User> getAttendUserByCid(int cid) {
		String sql = "select u from User u, Selection s where u.uid=s.uid and s.cid='"+cid+"'";
		@SuppressWarnings("unchecked")
		List<User> result = getSession().createQuery(sql).list();
		return result;
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.SelectionDao#getUserToAttendByCid(int)
	 */
	@Override
	public List<User> getUserToAttendByCid(int cid) {
		String sql = "select u from User u where u.uid not in (select s.uid from Selection s where s.cid='"+cid+"')";
		@SuppressWarnings("unchecked")
		List<User> result = getSession().createQuery(sql).list();
		return result;
	}

}

/**
 * 
 */
package com.ccl.dao;

import java.util.List;

import com.ccl.model.Selection;
import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午3:49:48
 * @version 1.0
 */
public interface SelectionDao extends BaseDao<Selection>{
	
	public boolean addSelection(int cid, String uid);
	
	public void delSelection(int cid, String uid);
	
	public Selection getSelectionByCidAndUid(int cid, String uid);
	
	public List<User> getAttendUserByCid(int cid);
	
	public List<User> getUserToAttendByCid(int cid);

}

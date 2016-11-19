/**
 * 
 */
package com.ccl.dao;

import java.util.List;

import com.ccl.model.Assist;
import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午3:51:25
 * @version 1.0
 */
public interface AssistDao extends BaseDao<Assist>{
	
	public boolean addAssist(int cid, String uid);
	
	public void delAssist(int cid, String uid);
	
	public List<User> getAssistUserByCid(int cid);
	
	public List<User> getUserToAssistByCid(int cid);

}

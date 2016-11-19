/**
 * 
 */
package com.ccl.dao;

import java.util.List;

import com.ccl.model.Follow;
import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午3:51:25
 * @version 1.0
 */
public interface FollowDao extends BaseDao<Follow>{
	
	public boolean addFollow(int assignmentid, String uid);
	
	public List<User> getFollowUserByAssignmentid(int assignmentid);
	
	public Follow getFollowByAssignmentidAndUid(int assignmentid, String uid) ;
	
	public List<User> getUserToFollowByAssignmentid(int assignmentid);

}

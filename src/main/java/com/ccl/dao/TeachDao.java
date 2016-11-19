/**
 * 
 */
package com.ccl.dao;

import com.ccl.model.Teach;

/**
 *
 * @author 霄汉
 * @since 2016年3月16日 下午4:33:53
 * @version 1.0
 */
public interface TeachDao extends BaseDao<Teach>{
	
	public String getTeacherStringByCid(int cid);

}

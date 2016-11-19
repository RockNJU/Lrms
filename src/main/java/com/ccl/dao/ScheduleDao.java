/**
 * 
 */
package com.ccl.dao;

import com.ccl.model.Schedule;

/**
 *
 * @author 霄汉
 * @since 2016年3月16日 下午5:13:19
 * @version 1.0
 */
public interface ScheduleDao extends BaseDao<Schedule>{
	
	public String getSemesterName(int cid);

}

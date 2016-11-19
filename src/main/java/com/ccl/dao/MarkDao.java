/**
 * 
 */
package com.ccl.dao;

import java.util.List;

import com.ccl.model.Mark;

/**
 *
 * @author 霄汉
 * @since 2016年3月21日 下午2:40:01
 * @version 1.0
 */
public interface MarkDao extends BaseDao<Mark>{
	
	public void overwriteMark(Mark mark);
	
	public List<Mark> getAllMarks(int assignmentid);
	

}

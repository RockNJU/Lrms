/**
 * 
 */
package com.ccl.dao;

import java.util.List;

import com.ccl.model.Assignment;
import com.ccl.model.Manage;
import com.ccl.model.Report;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午3:51:25
 * @version 1.0
 */
public interface ManageDao extends BaseDao<Manage>{
	
	public boolean addManage(int cid, int assignmentid);
	
	public void delManage(int cid, int assignmentid);
	
	public List<Integer> getCourseIdByAssignemntId(int aid);
	
	public List<Assignment> getAssignmentsByCid(int cid);
	
	public List<Assignment> getAssignmentsToImportByCid(int cid);
	
	public List<Report> getReportsExceptGivenCid(int cid);

}

/**
 * 
 */
package com.ccl.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.ManageDao;
import com.ccl.model.Assignment;
import com.ccl.model.Manage;
import com.ccl.model.Report;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午3:52:21
 * @version 1.0
 */
@Repository
@Transactional
public class ManageDaoImpl extends BaseDaoImpl<Manage> implements ManageDao{

	@Override
	public boolean addManage(int raid, int rid) {
		try {
			Manage a = new Manage();
			a.setCid(raid);
			a.setAssignmentid(rid);
			a.setCreatedAt(new Date());
			save(a);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public void delManage(int raid, int rid) {
		deleteByColumns(Manage.class, "raid", raid, "rid", rid);
		
	}
	
	@Override
	public List<Integer> getCourseIdByAssignemntId(int aid){
		String sql = "select m.cid from Manage m where m.assignmentid="+aid+"";
		@SuppressWarnings("unchecked")
		List<Integer> result = getSession().createQuery(sql).list();
		if(result==null){
			return new ArrayList<Integer>();
		}
		return result;
	}

	@Override
	public List<Assignment> getAssignmentsByCid(int cid) {
		String sql = "select a from Assignment a, Manage m where a.assignmentid=m.assignmentid and m.cid='"+cid+"'";
		@SuppressWarnings("unchecked")
		List<Assignment> result = getSession().createQuery(sql).list();
		return result;
	}

	@Override
	public List<Assignment> getAssignmentsToImportByCid(int cid) {
		String sql = "select a from Assignment a where a.assignmentid not in (select assignmentid from Manage m where m.cid='"+cid+"')";
		@SuppressWarnings("unchecked")
		List<Assignment> result = getSession().createQuery(sql).list();
		return result;
	}

	@Override
	public List<Report> getReportsExceptGivenCid(int cid) {
		String sql = "select r from Report r where r.assignmentid not in (select assignmentid from Manage m where m.cid='" + cid + "')";
		@SuppressWarnings("unchecked")
		List<Report> result = getSession().createQuery(sql).list();
		return result;
	}

}

/**
 * 
 */
package com.ccl.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.ReportDao;
import com.ccl.model.Report;

import ognl.OgnlException;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午4:40:02
 * @version 1.0
 */
@Repository
@Transactional
public class ReportDaoImpl extends BaseDaoImpl<Report> implements ReportDao{

	/* (non-Javadoc)
	 * @see com.ccl.dao.ReportDao#overwriteMark(com.ccl.model.Mark)
	 */
	@Override
	public void overwriteReport(Report report) {
//		Report oldOne = findByColumn(Report.class, "assignmentid", report.getAssignmentid());
//		List<Report> list = getListByColumn(Report.class, "assignmentid", report.getAssignmentid());
//		if (oldOne == null) {
//			save(report);
//		}else {
//			oldOne.setContent(report.getContent());
//			oldOne.setCreatedAt(report.getCreatedAt());
////			oldOne.setState(report.getState());
//			update(oldOne);
//		}
	}

}

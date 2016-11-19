/**
 * 
 */
package com.ccl.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.Utility;
import com.ccl.dao.AssignmentDao;
import com.ccl.model.Assignment;
import com.ccl.vo.SubmissionInfoVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午4:39:34
 * @version 1.0
 */
@Repository
@Transactional
public class AssignmentDaoImpl extends BaseDaoImpl<Assignment> implements AssignmentDao{

	/* (non-Javadoc)
	 * @see com.ccl.dao.AssignmentDao#getSubmissionInfo(int, java.lang.String)
	 */
	@Override
	public List<SubmissionInfoVO> getSubmissionInfo(int cid, String uid) {
		String sql = "select a.assignmentid,a.title,a.point,a.description,a.submitDeadline,s.submitTime,a.directionPath,a.reviewPath from (select * from assignment where cid='" +cid + "')a  left outer join (select * from submission where uid='" +uid+ "') s on a.assignmentid=s.assignmentid";
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> list = sqlQuery.list();
		ArrayList<SubmissionInfoVO> result = new ArrayList<SubmissionInfoVO>();
		Date today = new Date();
		for (Object[] row : list) {
			SubmissionInfoVO vo = new SubmissionInfoVO();
			vo.setAssignmentid((int)row[0]);
			vo.setTitle((String)row[1]);
			vo.setPoint((double)row[2]);
			vo.setDescription((String)row[3]);
			Date ddl = (Date)(row[4]);
			vo.setDeadline(Utility.formatDate(ddl));
			if (ddl.before(today)) {
				vo.setIsOver(true);
			}else {
				vo.setIsOver(false);
			}
			if (row[5] == null) {
				vo.setSubmited("未提交");
			}else {
				vo.setSubmited(Utility.formatDateTime((Date)(row[5])));
			}
			vo.setDirectionPath((String)row[6]);
			vo.setReviewPath((String)row[7]);
			result.add(vo);
		}
		return result;
	}

}

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

import com.ccl.dao.MarkDao;
import com.ccl.model.Mark;

/**
 *
 * @author 霄汉
 * @since 2016年3月21日 下午2:40:43
 * @version 1.0
 */
@Repository
@Transactional
public class MarkDaoImpl extends BaseDaoImpl<Mark> implements MarkDao{

	/* (non-Javadoc)
	 * @see com.ccl.dao.MarkDao#overwriteMark(com.ccl.model.Mark)
	 */
	@Override
	public void overwriteMark(Mark mark) {
		Mark oldOne = findByColumns(Mark.class, "assignmentid", mark.getAssignmentid(), "uid", mark.getUid());
		if (oldOne == null) {
			save(mark);
		}else {
			oldOne.setComment(mark.getComment());
			oldOne.setCreatedAt(mark.getCreatedAt());
			oldOne.setMark(mark.getMark());
			update(oldOne);
		}
	}

	/* (non-Javadoc)
	 * @see com.ccl.dao.MarkDao#getAllMarks(int)
	 */
	@Override
	public List<Mark> getAllMarks(int assignmentid) {
		String sql = "select u.uid,m.assignmentid,m.mark,m.comment,m.createdAt from (select uid from selection,assignment where selection.cid=assignment.cid and assignmentid='" +assignmentid + "')u  left outer join mark m on u.uid=m.uid";
		SQLQuery sqlQuery = this.getSession().createSQLQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> list = sqlQuery.list();
		ArrayList<Mark> result = new ArrayList<Mark>();
		for (Object[] row : list) {
			Mark m = new Mark();
			m.setUid((String)row[0]);
			m.setAssignmentid(assignmentid);
			if (row[2] == null) {
				m.setMark(-1);
			}else {
				m.setMark((double)(row[2]));
			}
			m.setComment((String)row[3]);
			m.setCreatedAt((Date)row[4]);
			result.add(m);
		}
		return result;
	}
	
	
	
	

}

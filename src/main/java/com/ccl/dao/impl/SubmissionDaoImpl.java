/**
 * 
 */
package com.ccl.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.SubmissionDao;
import com.ccl.model.Submission;

/**
 *
 * @author 霄汉
 * @since 2016年3月21日 下午2:08:30
 * @version 1.0
 */
@Repository
@Transactional
public class SubmissionDaoImpl extends BaseDaoImpl<Submission> implements SubmissionDao{

	/* (non-Javadoc)
	 * @see com.ccl.dao.SubmissionDao#updateSubmissionRecord(com.ccl.model.Submission)
	 */
	@Override
	public void overwriteSubmissionRecord(Submission submission) {
		Submission oldOne = findByColumns(Submission.class, "assignmentid", 
				submission.getAssignmentid(), "uid", submission.getUid());
		if (oldOne == null) {
			save(submission);
		}else {
			oldOne.setFormat(submission.getFormat());
			oldOne.setPath(submission.getPath());
			oldOne.setSubmitTime(submission.getSubmitTime());
			update(oldOne);
		}
		
	}
	

}

/**
 * 
 */
package com.ccl.dao;

import com.ccl.model.Submission;

/**
 *
 * @author 霄汉
 * @since 2016年3月21日 下午2:08:07
 * @version 1.0
 */
public interface SubmissionDao extends BaseDao<Submission>{
	
	public void overwriteSubmissionRecord(Submission submission);

}

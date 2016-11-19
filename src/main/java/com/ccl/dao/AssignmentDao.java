/**
 * 
 */
package com.ccl.dao;

import java.util.List;

import com.ccl.model.Assignment;
import com.ccl.vo.SubmissionInfoVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午4:39:10
 * @version 1.0
 */
public interface AssignmentDao extends BaseDao<Assignment>{
	
	public List<SubmissionInfoVO> getSubmissionInfo(int cid, String uid);

}

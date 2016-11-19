/**
 * 
 */
package com.ccl.dao;

import java.util.List;

import com.ccl.model.Notice;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 上午9:28:07
 * @version 1.0
 */
public interface NoticeDao extends BaseDao<Notice>{
	
	public List<Notice> getMyNotice(String uid);

}

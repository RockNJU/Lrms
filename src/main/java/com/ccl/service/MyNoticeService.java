/**
 * 
 */
package com.ccl.service;

import java.util.List;

import com.ccl.model.Notice;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 上午9:23:12
 * @version 1.0
 */
public interface MyNoticeService {
	
	public List<Notice> getMyNotice(String uid);

}

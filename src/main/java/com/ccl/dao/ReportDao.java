/**
 * 
 */
package com.ccl.dao;

import com.ccl.model.Report;

/**
 *
 * @author 霄汉
 * @since 2016年3月19日 下午4:40:20
 * @version 1.0
 */
public interface ReportDao extends BaseDao<Report>{
	
	public void overwriteReport(Report report);

}

/**
 * 
 */
package com.ccl.service;

import java.util.Date;
import java.util.List;

import com.ccl.vo.StatisticsVO;

/**
 *
 * @author 霄汉
 * @since 2016年3月21日 下午8:07:41
 * @version 1.0
 */
public interface StatisticsService {
	
	public List<StatisticsVO> getRecoStatics(Date start, Date end);
	
	public List<StatisticsVO> getProbStatics(Date start, Date end);

}

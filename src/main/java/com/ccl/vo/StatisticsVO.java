/**
 * 
 */
package com.ccl.vo;

import com.ccl.model.Assignment;

/**
 *
 * @author 霄汉
 * @since 2016年3月21日 下午7:57:03
 * @version 1.0
 */
public class StatisticsVO {
	
	public Assignment assignment;
	
	public int count;
	
	public StatisticsVO(Assignment assignment, int count) {
		this.assignment = assignment;
		this.count = count;
	}
	
	public Assignment getAssignment() {
		return assignment;
	}
	
	public int getCount() {
		return count;
	}
	
}

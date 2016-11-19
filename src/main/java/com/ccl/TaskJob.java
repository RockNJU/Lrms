/**
 * 
 */
package com.ccl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ccl.service.TaskJobService;

/**
 *
 * @author 霄汉
 * @since 2016年3月23日 上午8:39:56
 * @version 1.0
 */
@Component("taskJob")
public class TaskJob {
	
	@Autowired
	private TaskJobService service;
	
	@Scheduled(cron = "0 0 * * * ?")
	public void doJob() {
		service.updateState();
	}

}

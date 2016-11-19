/**
 * 
 */
package com.ccl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccl.dao.SemesterDao;
import com.ccl.model.Semester;
import com.ccl.service.SemesterService;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 上午11:41:34
 * @version 1.0
 */
@Service
public class SemesterServiceImpl implements SemesterService{
	
	@Autowired
	private SemesterDao dao;

	/* (non-Javadoc)
	 * @see com.ccl.service.SemesterService#getSemesters()
	 */
	@Override
	public List<Semester> getSemesters() {
		return dao.getAllList(Semester.class);
	}

	/* (non-Javadoc)
	 * @see com.ccl.service.SemesterService#addSemester(com.ccl.model.Semester)
	 */
	@Override
	public boolean addSemester(Semester semester) {
		dao.save(semester);
		return true;
	}

	
}

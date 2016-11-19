/**
 * 
 */
package com.ccl.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.SemesterDao;
import com.ccl.model.Semester;

/**
 *
 * @author 霄汉
 * @since 2016年3月15日 上午11:42:34
 * @version 1.0
 */
@Repository
@Transactional
public class SemesterDaoImpl extends BaseDaoImpl<Semester> implements SemesterDao{

}

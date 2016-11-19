/**
 * 
 */
package com.ccl.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.TeacherDao;
import com.ccl.model.Teacher;

/**
 *
 * @author 霄汉
 * @since 2016年3月13日 下午1:14:55
 * @version 1.0
 */
@Repository
@Transactional
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao{
	

}

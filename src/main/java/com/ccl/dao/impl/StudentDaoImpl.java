/**
 * 
 */
package com.ccl.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ccl.dao.StudentDao;
import com.ccl.model.Student;

/**
 *
 * @author 霄汉
 * @since 2016年3月13日 下午1:15:21
 * @version 1.0
 */
@Repository
@Transactional
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao{


}

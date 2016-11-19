/**
 * 
 */
package com.ccl.service;

import java.util.ArrayList;

/**
 *
 * @author 霄汉
 * @since 2016年3月10日 下午9:07:50
 * @version 1.0
 */
public interface UserRegisterService {
	
	public String register(ArrayList<String> uids);
	
	public String batchRegister(String start, String end);
	
	public void registerAdmin();

}

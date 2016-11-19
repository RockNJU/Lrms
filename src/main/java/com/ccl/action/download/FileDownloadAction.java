/**
 * 
 */
package com.ccl.action.download;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.stereotype.Controller;

import com.ccl.action.BaseAction;

/**
 *
 * @author 霄汉
 * @since 2016年3月22日 下午10:54:21
 * @version 1.0
 */
@Controller
public class FileDownloadAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8193617832049920261L;
	private String fileName;
	
	public InputStream getDownloadFile() throws Exception {
		String uri = request.getParameter("uri");
		setFileName(uri.substring(uri.lastIndexOf('/') + 1));
		InputStream inputStream = new FileInputStream(uri);
		return inputStream;
	}
	
	public String execute() {
		return SUCCESS;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}

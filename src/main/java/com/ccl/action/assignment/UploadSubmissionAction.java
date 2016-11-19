/**
 * 
 */
package com.ccl.action.assignment;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ccl.Utility;
import com.ccl.action.BaseAction;
import com.ccl.model.Submission;
import com.ccl.service.AssignmentService;

/**
 *
 * @author 霄汉
 * @since 2016年3月20日 下午4:06:07
 * @version 1.0
 */
@Controller
public class UploadSubmissionAction extends BaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7994816264644550583L;

	@Autowired
	AssignmentService service;
	
	private File file;  //注意file名与表单name对应
    private String fileFileName;  //file+FileName为固定写法,否则取不到
//    private String fileContentType;  //file+ContentType为固定写法
  
    private String result;  
      
    public String execute(){        
    	String uid = request.getParameter("uid");
    	int assignmentid = Integer.parseInt(request.getParameter("assignmentid"));
        String path = Utility.getAssignmentDirectory(request, assignmentid); 
        String targetFileName = path + uid  +fileFileName.substring(fileFileName.lastIndexOf('.'));
        boolean flag = Utility.uploadFile(file, fileFileName, targetFileName);
        if (flag) {
        	Submission submission = new Submission();
        	submission.setAssignmentid(assignmentid);
        	submission.setFormat(fileFileName.substring(fileFileName.lastIndexOf('.')));
        	submission.setPath(targetFileName);
        	submission.setSubmitTime(new Date());
        	submission.setUid(uid);
        	service.writeSubmissionRecord(submission);
        	result = "success";
        }else {
        	result = "fail";
        }
        return SUCCESS;
          
    }

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}  
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

}

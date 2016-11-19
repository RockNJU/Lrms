/**
 * 
 */
package com.ccl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;

import com.ccl.model.User;

/**
 *
 * @author 霄汉
 * @since 2016年3月9日 上午10:45:44
 * @version 1.0
 */
/**
 *
 * @author 霄汉
 * @since 2016年3月20日 上午10:47:53
 * @version 1.0
 */
public class Utility {
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public static User getUser(HttpServletRequest request) {
		return (User)(request.getSession().getAttribute("user"));
	}
	
	
	public static Date parseDate(String s) {
		String [] ss = s.split("-");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, Integer.parseInt(ss[0]));
		c.set(Calendar.MONTH, Integer.parseInt(ss[1]) - 1);
		c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(ss[2]));
		return c.getTime();
	}
	
	public static String formatDateTime(Date d) {
		return formatDateTime.format(d);
	}
	
	public static String formatDate(Date d) {
		return format.format(d);
	}
	
	public static String getRootDirectory(HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/");
		System.out.println(path.replace('\\', '/'));
		return path.replace('\\', '/');
	}
	
	public static String getAssignmentDirectory(HttpServletRequest request, int assignmentid) {
		String path = getRootDirectory(request) + "assignments/" + assignmentid + "/";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return path;
	}

	public static String getDirectionDirectory(HttpServletRequest request) {
		String path = getRootDirectory(request) + "directions/";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return path;
	}
	public static String getReviewsDirectory(HttpServletRequest request) {
		String path = getRootDirectory(request) + "reviews/";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return path;
	}
	
	public static String getRandomZipFileName(int assignmentid) {
		return assignmentid + "--" + new Date().getTime();
	}
	
	//将assignmentid对应的全部风险压缩为一个zip并返回完整路径
	public static String zipAssignments(HttpServletRequest request, int assignmentid) {
		String assignmentDir = getAssignmentDirectory(request, assignmentid);
		String filename = getRandomZipFileName(assignmentid);
		boolean flag = fileToZip(assignmentDir, getRootDirectory(request) + "zipToDownload/", filename);
		if (flag) {
			return getRootDirectory(request) + "zipToDownload/" +filename + ".zip";
		}else {
			return null;
		}
	}
	
	/** 
     * 将存放在sourceFilePath目录下的源文件，打包成fileName名称的zip文件，并存放到zipFilePath路径下 
     * @param sourceFilePath :待压缩的文件路径 
     * @param zipFilePath :压缩后存放路径 
     * @param fileName :压缩后文件的名称 （不包括。zip)
     * @return 
     */  
    public static boolean fileToZip(String sourceFilePath,String zipFilePath,String fileName){  
        boolean flag = false;  
        File sourceFile = new File(sourceFilePath);  
        FileInputStream fis = null;  
        BufferedInputStream bis = null;  
        FileOutputStream fos = null;  
        ZipOutputStream zos = null;  
          
        if(sourceFile.exists() == false){  
            sourceFile.mkdirs();  
        }
        
            try {  
                File zipFile = new File(zipFilePath + "/" + fileName +".zip");  
                if(zipFile.exists()){  
                    System.out.println(zipFilePath + "目录下存在名字为:" + fileName +".zip" +"打包文件.");  
                }else{  
                    File[] sourceFiles = sourceFile.listFiles();  
                    if(null == sourceFiles || sourceFiles.length<1){  
                        System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");  
                    }else{  
                        fos = new FileOutputStream(zipFile);  
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));  
                        byte[] bufs = new byte[1024*10];  
                        for(int i=0;i<sourceFiles.length;i++){  
                            //创建ZIP实体，并添加进压缩包  
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());  
                            zos.putNextEntry(zipEntry);  
                            //读取待压缩的文件并写进压缩包里  
                            fis = new FileInputStream(sourceFiles[i]);  
                            bis = new BufferedInputStream(fis, 1024*10);  
                            int read = 0;  
                            while((read=bis.read(bufs, 0, 1024*10)) != -1){  
                                zos.write(bufs,0,read);  
                            }  
                        }  
                        flag = true;  
                    }  
                }  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
                throw new RuntimeException(e);  
            } catch (IOException e) {  
                e.printStackTrace();  
                throw new RuntimeException(e);  
            } finally{  
                //关闭流  
                try {  
                    if(null != bis) bis.close();  
                    if(null != zos) zos.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                    throw new RuntimeException(e);  
                }  
        }  
        return flag;  
    }  
    
    public static boolean uploadFile(File tmpFile, String originName, String targetFileName) {
        try {  
            FileInputStream inputStream = new FileInputStream(tmpFile);  
            File targetFile = new File(targetFileName);
            if (!targetFile.exists()) {
            	targetFile.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(targetFile);  
            byte[] buf = new byte[1024];  
            int length = 0;  
            while ((length = inputStream.read(buf)) != -1) {  
                outputStream.write(buf, 0, length);  
            }  
            inputStream.close();  
            outputStream.flush();  
            outputStream.close();
            return true;
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;
        }  
    }

}

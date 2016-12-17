package com.ishop.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.ishop.common.util.FTPUtils;

public class TestFTP {
	
//	public void uploadFile() throws IOException{
//		FTPClient ftpClient = new FTPClient();
//		FileInputStream fis = null;
//		try {
//			//连接server
//			ftpClient.connect("127,0,0,1",21);
//			
//			ftpClient.login("user", "123456");
//			//类型；
//			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//			ftpClient.changeWorkingDirectory("/www/images");
//			fis = new FileInputStream(new File("D:/用户目录/我的图片/Camera/hello1.jpg"));
//			//传送数据
//			ftpClient.storeFile("/ftp/www/image/hello.jpg", fis);
//			
//			
//		} catch (IOException e) {
//		
//			e.printStackTrace();
//		}finally{
//			ftpClient.logout();
//			fis.close();
//		}
//	}
//	
//	public static void main() throws IOException{
////		FTPUtils test = new FTPUtils();
////		test.uploadFile("127.0.0.1", 21, "user", "123456", null, "/", "hello1.jpg", input)
//		TestFTP test = new TestFTP();
//		test.uploadFile();
//	}
	@Test
	public void up() throws FileNotFoundException {
		FTPUtils.uploadFile("192.168.16.84", 21, "user", "123456", null, "/images", "a1.jpg", new FileInputStream(new File("D:\\用户目录\\我的图片\\Camera\\image\\20160722_105830.jpg")));
	}
}

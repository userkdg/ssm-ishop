package com.ishop.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.ishop.common.util.FtpUtil;
import com.ishop.common.util.IDUtils;
import com.ishop.common.util.PictureResult;
import com.ishop.service.PicUploadService;

@Service
public class PicUploadServiceImpl implements PicUploadService {
	
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	
	@Value("${FTP_SERVER_IP}")
	private String FTP_SERVER_IP;
	
	@Value("${FTP_SERVER_PORT}")
	private Integer FTP_SERVER_PORT;
	
	@Value("${FTP_SERVER_USERNAME}")
	private String FTP_SERVER_USERNAME;

	@Value("${FTP_SERVER_PASSWORD}")
	private String FTP_SERVER_PASSWORD;

	@Value("${FILI_UPLOAD_PATH}")
	private String FILI_UPLOAD_PATH;
	
	@Override
	public PictureResult pictureFile(MultipartFile uploadFile) {
		// 返回批量PictureResult

		// 上传文件功能实现
		String path = savePicture(uploadFile);
		// 回显
		PictureResult result = new PictureResult(0, IMAGE_BASE_URL + path);
		return result;
	}

	private String savePicture(MultipartFile uploadFile) {
		String result = null;
		try {
			// 上传文件功能实现
			// 判断文件是否为空
			if (uploadFile.isEmpty())
				return null;
			// 上传文件以日期为单位分开存放，可以提高图片的查询速度
			String filePath = "/" + new SimpleDateFormat("yyyy").format(new Date()) + "/"
					+ new SimpleDateFormat("MM").format(new Date()) + "/"
					+ new SimpleDateFormat("dd").format(new Date());

			// 取原始文件名
			String originalFilename = uploadFile.getOriginalFilename();
			// 新文件名
			String newFileName = IDUtils.genImageName() + originalFilename.substring(originalFilename.lastIndexOf("."));
			// 转存文件，上传到ftp服务器
			FtpUtil.uploadFile(FTP_SERVER_IP, FTP_SERVER_PORT, FTP_SERVER_USERNAME, FTP_SERVER_PASSWORD,
					FILI_UPLOAD_PATH, filePath, newFileName, uploadFile.getInputStream());
			result = filePath + "/" + newFileName;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	//spring 的upload
	public PictureResult uploadPic(MultipartFile uploadFile){
		if (uploadFile.isEmpty())
			return null;
		// 上传文件以日期为单位分开存放，可以提高图片的查询速度
		String filePath = "/" + new SimpleDateFormat("yyyy").format(new Date()) + "/"
				+ new SimpleDateFormat("MM").format(new Date()) + "/"
				+ new SimpleDateFormat("dd").format(new Date());

		// 取原始文件名
		String originalFilename = uploadFile.getOriginalFilename();
		// 新文件名
		String newFileName = IDUtils.genImageName() + originalFilename.substring(originalFilename.lastIndexOf("."));
		
		
		OutputStream os = new OutputStream() {
			
			
			
			@Override
			public void write(int b) throws IOException {
				
				
			}
		};
		
		return null;
		
	}
	
}

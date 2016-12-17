package com.ishop.service;

import org.springframework.web.multipart.MultipartFile;

import com.ishop.common.util.PictureResult;

/**
 * 上传图片
 * @author Administrator
 *
 */
public interface PicUploadService {
	PictureResult pictureFile(MultipartFile uploadFile);
}

package com.ishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ishop.common.util.JsonUtils;
import com.ishop.common.util.PictureResult;
import com.ishop.service.PicUploadService;

@Controller
public class PicUploadController {
	@Autowired
	private PicUploadService picUploadService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String picUpload(MultipartFile uploadFile){
		PictureResult result = picUploadService.pictureFile(uploadFile);
		String stringResult = JsonUtils.objectToJson(result);
		return stringResult;
	}
}

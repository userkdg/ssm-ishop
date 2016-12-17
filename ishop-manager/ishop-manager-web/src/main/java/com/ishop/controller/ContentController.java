/**
 * 
 */
package com.ishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishop.common.util.DataList;
import com.ishop.service.ContentService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/content/query")
public class ContentController {
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/list")
	@ResponseBody
	public DataList getContentList(Integer page, Integer rows){
		DataList result = contentService.getContentList(page, rows);
		return result;
	}
}

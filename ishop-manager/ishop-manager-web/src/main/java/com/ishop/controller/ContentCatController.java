/**
 * 
 */
package com.ishop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishop.common.util.EUTreeNode;
import com.ishop.service.ContentCatService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/content/category")
public class ContentCatController {
	@Autowired
	private ContentCatService contentCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCatList(@RequestParam(value="id",defaultValue="0")long parentId){
		List<EUTreeNode> result = contentCatService.getContentCatList(parentId);
		return result;
	}
}

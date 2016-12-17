/**
 * 
 */
package com.ishop.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishop.common.util.IshopResult;
import com.ishop.pojo.TbContent;
import com.ishop.restful.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired(required=false)
	private ContentService contentService;
	
	@RequestMapping("/list/{cid}")
	@ResponseBody
	public IshopResult getContentList(@PathVariable Long cid) {
		try {
			List<TbContent> list = contentService.getContentList(cid);
			return IshopResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return IshopResult.build(500, "null!!!!");
		}
	}
}
package com.ishop.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishop.common.util.IshopResult;
import com.ishop.restful.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public IshopResult getItemBaseInfo(@PathVariable Long itemId) {
		IshopResult result = itemService.getItemBaseInfo(itemId);
		return result;
	}
	//显示商品描述列表
	@RequestMapping("/desc/{itemId")
	@ResponseBody
	public IshopResult getItemDesc(@PathVariable Long itemId){
		IshopResult result = itemService.getItemDesc(itemId);
		return result;
	}
	//显示商品参数列表
	@RequestMapping("/param/list/{itemId}")
	@ResponseBody
	public IshopResult getItemParam(@PathVariable Long itemId){
		IshopResult result = itemService.getItemParam(itemId);
		return result;
	}
	
	//删除商品
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public String deleteItem(Long itemId) {
		itemService.deleteItem(itemId);
		return "item-list";
	}
}
package com.ishop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishop.common.util.DataList;
import com.ishop.common.util.IshopResult;
import com.ishop.pojo.TbItem;
import com.ishop.pojo.TbItemDesc;
import com.ishop.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public DataList getItemList(Integer page, Integer rows){
		DataList itemList = itemService.getItemList(page, rows);
		return itemList;
	}
	
	@RequestMapping("/item/save")
	@ResponseBody
	public IshopResult saveItem(TbItem item, String desc) throws Exception {
		//添加商品信息
		itemService.saveItem(item, desc, null);
		return IshopResult.ok();
	}
	
	@RequestMapping(value="/item/delete/{itemId}")
	public String deleteItem(@PathVariable Long itemId) throws Exception {
		//delete商品信息
		itemService.deleteItem(itemId);
		return "item-list";
	}
	//跳转到商品编辑页面
	@RequestMapping("/page/item-edit")
	public String editItem(){
		return "item-edit";
	}
	
	//获取商品的/item/query/item/desc/'+data.id,
	/*@RequestMapping("/item/query/item/desc/{itemId}")
	@ResponseBody
	public TbItemDesc getItemDesc(@PathVariable long itemId){
		TbItemDesc itemDesc = itemService.getItemDesc(itemId);
		return itemDesc;
	}*/
	//item-param-list跳转到商品 规格参数页面
	@RequestMapping("/item/param/list")
	@ResponseBody
	public DataList getItemParamList(Integer page, Integer rows){
		DataList itemParamList = itemService.getItemParamItemList(page, rows);
		return itemParamList;
	}
	//获取商品的/item/param/item/query/'+data.id 规格
//	@RequestMapping("/item/query/item/desc/{itemId}")
//	@ResponseBody
//	public TbItemDesc get(@PathVariable long itemId){
//		TbItemDesc itemDesc = itemService.getItemDesc(itemId);
//		return itemDesc;
//	}

}
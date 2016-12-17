package com.ishop.restful.service;

import com.ishop.common.util.IshopResult;

public interface ItemService {
//获取商品基本信息
	IshopResult getItemBaseInfo(long itemId);
	 
	IshopResult getItemParam(long itemId);

	IshopResult getItemDesc(long itemId);

	IshopResult deleteItem(Long itemId);
}

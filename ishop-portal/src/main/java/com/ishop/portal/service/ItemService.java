package com.ishop.portal.service;

import com.ishop.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(Long itemId);

	String getItemDescById(Long itemId);

	String getItemParam(Long itemId);
	
}

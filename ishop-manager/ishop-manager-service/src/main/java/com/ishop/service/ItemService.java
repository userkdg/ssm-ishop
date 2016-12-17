package com.ishop.service;


import com.ishop.common.util.DataList;
import com.ishop.common.util.IshopResult;
import com.ishop.pojo.TbItem;
import com.ishop.pojo.TbItemDesc;

public interface ItemService {
	TbItem getItemById(long itemId);
	DataList getItemList(int page, int rows);
	void saveItem(TbItem item, String desc, String itemParams) throws Exception;
	void deleteItem(long itemId);
	TbItemDesc getItemDesc(long itemId);
	DataList getItemParamItemList(int page, int rows);
}

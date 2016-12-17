package com.ishop.service;

import java.util.List;


/**
 * 商品列表业务层
 * @author Administrator
 *
 */
public interface ItemCatService {
	@SuppressWarnings("rawtypes")
	List getItemCatList(Long parentId);
}

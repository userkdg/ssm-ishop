package com.ishop.restful.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ishop.common.util.CatNode;
import com.ishop.mapper.TbItemCatMapper;
import com.ishop.pojo.TbItemCat;
import com.ishop.pojo.TbItemCatExample;
import com.ishop.pojo.TbItemCatExample.Criteria;
import com.ishop.restful.service.ItemCategoryService;
import com.ishop.restful.util.CatResult;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
	@Autowired
	private TbItemCatMapper itemCatMapper;
	
	@Override
	public CatResult getItemCatList() {
		
		CatResult catResult = new CatResult();
		//查询分类列表
		catResult.setData(getCatList(0));
		return catResult;
	}

/**
 * 查询分类列表
 * <p>Title: getCatList</p>
 * <p>Description: </p>
 * @param parentId
 * @return
 */
	private List<?> getCatList(long parentId) {
	//创建查询条件
	TbItemCatExample example = new TbItemCatExample();
	Criteria criteria = example.createCriteria();
	criteria.andParentIdEqualTo(parentId);
	//执行查询
	List<TbItemCat> list = itemCatMapper.selectByExample(example);
	//返回值list
	List resultList = new ArrayList<>();
	//向list中添加节点
	for (TbItemCat tbItemCat : list) {
		//判断是否为父节点
		if (tbItemCat.getIsParent()) {
			CatNode catNode = new CatNode();
			if (parentId == 0) {
				catNode.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
			} else {
				catNode.setName(tbItemCat.getName());
			}
			catNode.setUrl("/products/"+tbItemCat.getId()+".html");
			catNode.setItem(getCatList(tbItemCat.getId()));
			
			resultList.add(catNode);
		//如果是叶子节点
		} else {
			resultList.add("/products/"+tbItemCat.getId()+".html|" + tbItemCat.getName());
		}
	}
	return resultList;
}

}

package com.ishop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishop.common.util.EUTreeNode;
import com.ishop.mapper.TbItemCatMapper;
import com.ishop.pojo.TbItemCat;
import com.ishop.pojo.TbItemCatExample;
import com.ishop.pojo.TbItemCatExample.Criteria;
import com.ishop.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	@Autowired
	private TbItemCatMapper itemCatMapper;
/*
 * 获取商品分类列表；
 * @see com.ishop.service.ItemCatService#getItemCatList(java.lang.Long)
 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getItemCatList(Long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		//根据parentId查询子节点
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//创建一个list来装以T不ItemCat转换成EUTreeNode类型
		List itemCatList = new ArrayList();
		for (TbItemCat tbItemCat : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			//如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
			node.setState( tbItemCat.getIsParent()?"closed":"open");
			
			itemCatList.add(node);
		}
		return itemCatList;
	}
}

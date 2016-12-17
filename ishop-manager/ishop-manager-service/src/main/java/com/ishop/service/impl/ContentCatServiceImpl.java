/**
 * 
 */
package com.ishop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ishop.common.util.EUTreeNode;
import com.ishop.mapper.TbContentCategoryMapper;
import com.ishop.pojo.TbContentCategory;
import com.ishop.pojo.TbContentCategoryExample;
import com.ishop.pojo.TbContentCategoryExample.Criteria;
import com.ishop.service.ContentCatService;

/**
 * @author Administrator
 *
 */
@Service
public class ContentCatServiceImpl implements ContentCatService{

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	
	@Override
	public List<EUTreeNode> getContentCatList(long parentId) {
		//根据parentid查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			//创建一个节点
			EUTreeNode node = new EUTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			
			resultList.add(node);
		}
		return resultList;
	}


}

/**
 * 
 */
package com.ishop.restful.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ishop.mapper.TbContentMapper;
import com.ishop.pojo.TbContent;
import com.ishop.pojo.TbContentExample;
import com.ishop.pojo.TbContentExample.Criteria;
import com.ishop.restful.service.ContentService;

/**
 * @author Administrator
 *
 */
public class ContentServiceImpl implements ContentService{

	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public List<TbContent> getContentList(long contentCid) {
		//根据内容分类id查询内容列表
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentCid);
		//执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		
		return list;
	}

}

/**
 * 
 */
package com.ishop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ishop.common.util.DataList;
import com.ishop.mapper.TbContentMapper;
import com.ishop.pojo.TbContent;
import com.ishop.pojo.TbContentExample;
import com.ishop.pojo.TbItem;
import com.ishop.pojo.TbContentExample.Criteria;
import com.ishop.service.ContentService;

/**
 * 内容管理 
 * @author Administrator
 *
 */
@Service
public class ContentServiceImpl implements ContentService{
	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public DataList getContentList(int page, int rows) {
		TbContentExample example = new TbContentExample();
	//	Criteria criteria = example.createCriteria();
	    List<TbContent> list = contentMapper.selectByExample(example);
		PageHelper.startPage(page, rows);
		  //创建一个返回对象
	    DataList dateList = new DataList();
	    //去记录列述；
	    dateList.setRows(list);
	  //取记录总条数
	  	PageInfo<TbContent> pageInfo = new PageInfo<>(list);
	  	dateList.setTotal(pageInfo.getTotal());
	  	return dateList;
	}
}

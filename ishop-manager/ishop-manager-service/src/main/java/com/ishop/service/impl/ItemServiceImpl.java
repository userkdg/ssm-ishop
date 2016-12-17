/**
 * 
 */
package com.ishop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ishop.common.util.DataList;
import com.ishop.common.util.IDUtils;
import com.ishop.mapper.TbItemDescMapper;
import com.ishop.mapper.TbItemMapper;
import com.ishop.mapper.TbItemParamItemMapper;
import com.ishop.pojo.TbItem;
import com.ishop.pojo.TbItemDesc;
import com.ishop.pojo.TbItemDescExample;
import com.ishop.pojo.TbItemExample;
import com.ishop.pojo.TbItemExample.Criteria;
import com.ishop.pojo.TbItemParamItem;
import com.ishop.pojo.TbItemParamItemExample;
import com.ishop.service.ItemService;

/**
 * @author Administrator
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	/*
	 * 根据商品id/进行数据回显
	 * @see com.ishop.service.ItemService#getItemById(long)
	 */
	@Override
	public TbItem getItemById(long itemId) {
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//添加查询条件
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
	}
	/*
	 * 获取item列表并 分页；
	 * @see com.ishop.service.ItemService#getItemList(long, java.util.List)
	 */
	@Override
	public DataList getItemList(int page, int rows) {
		TbItemExample itemExample = new TbItemExample();
		PageHelper.startPage(page, rows);
	    List<TbItem> list = itemMapper.selectByExample(itemExample);
	    //创建一个返回对象
	    DataList dateList = new DataList();
	    //去记录列述；
	    dateList.setRows(list);
	  //取记录总条数
	  	PageInfo<TbItem> pageInfo = new PageInfo<>(list);
	  	dateList.setTotal(pageInfo.getTotal());
	  	return dateList;
	}
	@Override
	public void saveItem(TbItem item, String desc, String itemParams) throws Exception {
		Date date = new Date();
		//获得商品id
		long id = IDUtils.getItemId();
		//添加商品信息
		item.setId(id);
		//商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setCreated(date);
		item.setUpdated(date);
		itemMapper.insert(item);
		//添加商品描述
		//创建TbItemDesc对象
		TbItemDesc itemDesc = new TbItemDesc();
		//获得一个商品id
		itemDesc.setItemId(id);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		//插入数据
		itemDescMapper.insert(itemDesc);
	}

	/*
	 * 删除商品
	 */
	@Override
	public void deleteItem(long itemId){
		TbItemExample example = new TbItemExample();
		//创建查询条件
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		itemMapper.deleteByExample(example);
	}
	
	@Override
	public TbItemDesc getItemDesc(long itemId) {
		TbItemDescExample descExample = new TbItemDescExample();
		com.ishop.pojo.TbItemDescExample.Criteria criteria = descExample.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		//
		List<TbItemDesc> list = itemDescMapper.selectByExample(descExample);
		if (list != null && list.size() > 0) {
			TbItemDesc itemDesc = list.get(0);
			return itemDesc;
		}
		return null;
	}	
	//商品规格参数
	@Override
	public DataList getItemParamItemList(int page, int rows) {
		// 创建查询条件
		TbItemParamItemExample example = new TbItemParamItemExample();

		PageHelper.startPage(page, rows);
	    List<TbItemParamItem> list =  itemParamItemMapper.selectByExample(example);
	    //创建一个返回对象
	    DataList dateList = new DataList();
	    //去记录列述；
	    dateList.setRows(list);
	  //取记录总条数
	  	PageInfo<TbItemParamItem> pageInfo = new PageInfo<>(list);
	  	dateList.setTotal(pageInfo.getTotal());
	  	return dateList;
	}

}

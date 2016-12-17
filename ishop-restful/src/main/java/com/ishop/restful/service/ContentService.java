package com.ishop.restful.service;

import java.util.List;

import com.ishop.pojo.TbContent;

public interface ContentService {
	List<TbContent> getContentList(long contentCid);
}

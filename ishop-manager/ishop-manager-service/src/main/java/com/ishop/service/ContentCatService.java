package com.ishop.service;

import java.util.List;

import com.ishop.common.util.EUTreeNode;

public interface ContentCatService {
	List<EUTreeNode> getContentCatList(long parentId);
}

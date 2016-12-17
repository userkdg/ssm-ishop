/**
 * 
 */
package com.ishop.service;

import com.ishop.common.util.DataList;

/**
 * @author Administrator
 *
 */
public interface ContentService {
	DataList getContentList(int page, int rows);
}

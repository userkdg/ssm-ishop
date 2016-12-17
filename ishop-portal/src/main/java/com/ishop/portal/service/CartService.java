package com.ishop.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ishop.common.util.IshopResult;
import com.ishop.portal.pojo.CartItem;

public interface CartService {

	IshopResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);
	List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
	IshopResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}

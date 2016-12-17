package com.ishop.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ishop.common.util.IshopResult;
import com.ishop.pojo.TbUser;


public interface UserService {

	IshopResult checkData(String content, Integer type);
	IshopResult createUser(TbUser user);
	IshopResult userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);
	IshopResult getUserByToken(String token);
}

package com.ishop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 实现页面跳转；
 * @author Administrator
 *
 */

@Controller
public class PageController {

	/**
	 * 打开首页
	 */
	@RequestMapping("/index")
	public String showIndex() {
		return "index";
	}
	
	/*
	 * 登陆后台管理
	 */
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	/**
	 * 展示其他页面
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}
}
package com.ishop.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ishop.common.util.IshopResult;
import com.ishop.sso.service.RedisService;

@Controller
@RequestMapping("/cache/sync")
public class RedisController {

		@Autowired
		private RedisService redisService;
		
		@RequestMapping("/content/{contentCid}")
		public IshopResult contentCacheSync(@PathVariable Long contentCid) {
			IshopResult result = redisService.syncContent(contentCid);
			return result;
		}
}

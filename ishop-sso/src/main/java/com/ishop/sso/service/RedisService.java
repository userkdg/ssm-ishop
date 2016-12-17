package com.ishop.sso.service;

import com.ishop.common.util.IshopResult;

public interface RedisService {

	IshopResult syncContent(long contentCid);

}

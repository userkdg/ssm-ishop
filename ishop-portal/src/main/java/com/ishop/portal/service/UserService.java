/**
 * 
 */
package com.ishop.portal.service;

import com.ishop.pojo.TbUser;

/**
 * @author Administrator
 *
 */
public interface UserService {
	TbUser getUserByToken(String token);
}

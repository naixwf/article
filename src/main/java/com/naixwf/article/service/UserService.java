package com.naixwf.article.service;

import com.naixwf.article.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by wangfei on 14-10-30.
 * 用户、角色相关
 */
public interface UserService {
	/**
	 * 返回所有的用户
	 * @return
	 */
	List<User> getAll();
}

package com.naixwf.article.service;

import com.naixwf.article.domain.Authority;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfei on 14-11-4.
 */
public interface AuthorityService {
	/**
	 * 获取所有权限配置
	 * @return
	 */
	List<Authority> getAll();

	/**
	 * 修改某用户权限
	 * @param username
	 * @param authority
	 */
	void modify(String username, String authority);

}

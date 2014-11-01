package com.naixwf.article.service.impl;

import com.naixwf.article.domain.User;
import com.naixwf.article.domain.UserExample;
import com.naixwf.article.persistence.UserMapper;
import com.naixwf.article.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangfei on 14-10-30.
 */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> getAll() {
		UserExample e = new UserExample();
		List<User> list = userMapper.selectByExample(e);
		if (CollectionUtils.isEmpty(list)) {
			list = Collections.EMPTY_LIST;
		}

		return list;
	}

}

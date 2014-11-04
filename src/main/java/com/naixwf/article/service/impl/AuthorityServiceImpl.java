package com.naixwf.article.service.impl;

import com.naixwf.article.domain.Authority;
import com.naixwf.article.domain.AuthorityExample;
import com.naixwf.article.persistence.AuthorityMapper;
import com.naixwf.article.service.AuthorityService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangfei on 14-11-4.
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Resource
	private AuthorityMapper authorityMapper;

	@Override
	public List<Authority> getAll() {
		AuthorityExample e = new AuthorityExample();
		List<Authority> list = authorityMapper.selectByExample(e);
		if (CollectionUtils.isEmpty(list)) {
			list = Collections.EMPTY_LIST;
		}
		return list;
	}

	@Override
	public void modify(String username, String authority) {
		Authority a = new Authority();
		a.setUsername(username);
		a.setAuthority(authority);

		AuthorityExample e = new AuthorityExample();
		e.createCriteria().andUsernameEqualTo(username);

		authorityMapper.updateByExampleSelective(a, e);
	}
}

package com.naixwf.article.service.impl;

import com.naixwf.article.domain.Article;
import com.naixwf.article.domain.ArticleExample;
import com.naixwf.article.persistence.ArticleMapper;
import com.naixwf.article.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangfei on 14-10-30.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleMapper articleMapper;

	@Override
	public List<Article> getAll() {
		ArticleExample e = new ArticleExample();
		List<Article> list = articleMapper.selectByExample(e);

		if (CollectionUtils.isEmpty(list)) {
			list = Collections.EMPTY_LIST;
		}
		return list;
	}
}

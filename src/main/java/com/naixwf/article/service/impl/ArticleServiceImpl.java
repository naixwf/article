package com.naixwf.article.service.impl;

import com.naixwf.article.domain.Article;
import com.naixwf.article.domain.ArticleExample;
import com.naixwf.article.persistence.ArticleMapper;
import com.naixwf.article.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
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
		List<Article> list = articleMapper.selectByExampleWithBLOBs(e);

		if (CollectionUtils.isEmpty(list)) {
			list = Collections.EMPTY_LIST;
		}
		return list;
	}

	@Override
	public void add(Article article) {
		//TODO 从threadlocal 获取登陆的用户
		Integer userId = 0;
		Date now = new Date();

		article.setCreatorId(userId);
		article.setModifierId(userId);
		article.setCreateTime(now);
		article.setModifyTime(now);

		articleMapper.insert(article);
	}

	@Override
	public Article getById(int articleId) {
		return articleMapper.selectByPrimaryKey(articleId);
	}

	@Override
	public void modify(Article article) {
		Integer userId = 0;//TODO 从TreadLocal取数据
		Date now = new Date();

		article.setCreatorId(null);
		article.setCreateTime(null);

		article.setModifierId(userId);
		article.setModifyTime(now);

		articleMapper.updateByPrimaryKeySelective(article);
	}

	@Override
	public void delete(int articleId) {
		articleMapper.deleteByPrimaryKey(articleId);
	}
}

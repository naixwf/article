package com.naixwf.article.service.impl;

import com.naixwf.article.define.AuthorityDefine;
import com.naixwf.article.domain.Article;
import com.naixwf.article.domain.ArticleExample;
import com.naixwf.article.domain.ArticleWithBLOBs;
import com.naixwf.article.persistence.ArticleMapper;
import com.naixwf.article.service.ArticleService;
import org.markdown4j.Markdown4jProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by wangfei on 14-10-30.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);
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

	@Override
	public void add(ArticleWithBLOBs article) {

		article.setId(null);

		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal();
		Date now = new Date();

		article.setCreatorId(user.getUsername());
		article.setModifierId(user.getUsername());
		article.setCreateTime(now);
		article.setModifyTime(now);

		try {
			String html = new Markdown4jProcessor().process(article.getContent());
			article.setContentHtml(html);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		articleMapper.insert(article);
	}

	@Override
	public Article getById(int articleId) {
		int currentUserSecretLevel = AuthorityDefine.getCurrentUserSecretLevel();
		Article a = articleMapper.selectByPrimaryKey(articleId);
		if (a.getSecretLevel() <= currentUserSecretLevel) {
			return a;
		} else {
			LOGGER.debug("该用户secretLevel={},对id={}:secretLevel={}的文档没有权限", currentUserSecretLevel, articleId,
					a.getSecretLevel());
			return null;
		}
	}

	@Override
	public void modify(ArticleWithBLOBs article) {
		User user = (User) SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal();
		Date now = new Date();

		article.setCreatorId(null);
		article.setCreateTime(null);

		article.setModifierId(user.getUsername());
		article.setModifyTime(now);

		try {
			String html = new Markdown4jProcessor().process(article.getContent());
			article.setContentHtml(html);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		articleMapper.updateByPrimaryKeySelective(article);
	}

	@Override
	public void delete(int articleId) {
		articleMapper.deleteByPrimaryKey(articleId);
	}

	@Override
	public List<Article> getListLowerThanSecretLevel(int secretLevel) {
		ArticleExample e = new ArticleExample();
		e.createCriteria().andSecretLevelLessThanOrEqualTo(secretLevel);

		List<Article> list = articleMapper.selectByExample(e);
		if (CollectionUtils.isEmpty(list)) {
			list = Collections.EMPTY_LIST;
		}

		return list;
	}

	@Override
	public List<Article> getListByCategoryId(Integer categoryId) {
		ArticleExample e = new ArticleExample();
		e.createCriteria().andCategoryIdEqualTo(categoryId);

		List<Article> list = articleMapper.selectByExample(e);
		if (CollectionUtils.isEmpty(list)) {
			list = Collections.EMPTY_LIST;
		}

		return list;
	}
}

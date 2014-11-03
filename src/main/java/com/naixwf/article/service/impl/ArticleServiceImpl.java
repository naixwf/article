package com.naixwf.article.service.impl;

import com.naixwf.article.domain.Article;
import com.naixwf.article.domain.ArticleExample;
import com.naixwf.article.domain.ArticleWithBLOBs;
import com.naixwf.article.persistence.ArticleMapper;
import com.naixwf.article.service.ArticleService;
import org.markdown4j.Markdown4jProcessor;
import org.springframework.security.core.context.SecurityContextHolder;
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

		String username = (String) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();
		Date now = new Date();

		article.setCreatorId(username);
		article.setModifierId(username);
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
		return articleMapper.selectByPrimaryKey(articleId);
	}

	@Override
	public void modify(ArticleWithBLOBs article) {
		String username = (String) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();
		Date now = new Date();

		article.setCreatorId(null);
		article.setCreateTime(null);

		article.setModifierId(username);
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
}

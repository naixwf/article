/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.naixwf.article.service;

import com.naixwf.article.domain.Article;

import java.util.List;

/**
 * 文章相关的操作
 */
public interface ArticleService {
	/**
	 * 获取所有文章
	 * @return
	 */
	List<Article> getAll();

	/**
	 * 新增article
	 * @param article
	 */
	void add(Article article);

	/**
	 * 根据id获取文档
	 * @param articleId
	 * @return
	 */
	Article getById(int articleId);

	/**
	 * 修改文档
	 * @param article
	 */
	void modify(Article article);

	/**
	 * 删除制定id的文档
	 * @param articleId
	 */
	void delete(int articleId);
}

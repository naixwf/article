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

package com.naixwf.article.web;

import com.naixwf.article.domain.Article;
import com.naixwf.article.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 文档相关操作入口
 *
 * 题目(1) 实现文档管理功能(增删改)
 * 题目(2) 前台页面文档的查看
 * TODO
 * 文档列表
 * 新增文档
 * 修改文档
 * 删除文档
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
	@Resource
	private ArticleService articleService;

	/**
	 * 文章列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String list(Map<String, Object> model) {
		List<Article> list = articleService.getAll();
		model.put("articleList", list);
		return "article/list";
	}

	/**
	 * 查看一篇文章
	 */
	@RequestMapping("/view")
	public String view(Integer articleId, Map<String, Object> model) {
		//TODO stub
		return "article/view";
	}

	/**
	 * 新增一篇文章
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Map<String, Object> model) {
		//TODO stub
		return "article/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(Map<String, Object> model) {
		//TODO stub 重定向到view
		return null;
	}

	/**
	 * 修改一篇文章
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer articleId, Map<String, Object> model) {
		//TODO stub
		return "article/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(Integer articleId, Map<String, Object> model) {
		//TODO stub 重定向到view
		return null;
	}

	/**
	 * 删除一篇文档 TODO 权限
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postDelete(Integer articleId, Map<String, Object> model) {
		//TODO stub 重定向到view
		return null;
	}

}

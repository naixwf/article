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

import com.naixwf.article.domain.Category;
import com.naixwf.article.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 分类相关操作入口
 * 题目(2) 文档的分类管理和浏览
 * TODO
 * 分类列表
 * 新增分类
 * 修改分类
 * 删除分类
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
	@Resource
	private CategoryService categoryService;

	/**
	 * 分类列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String list(Map<String, Object> model) {
		List<Category> list = categoryService.getAll();
		model.put("categoryList", list);
		return "category/list";
	}

	/**
	 * 新增一个分类
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public
	@ResponseBody
	String
	postAdd(Category category, Map<String, Object> model) {
		categoryService.add(category);
		return "category postAdd completed: categoryId=" + category.getId();
	}

	/**
	 * 修改一个分类
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public
	@ResponseBody
	String postEdit(Category category, Map<String, Object> model) {
		categoryService.modify(category);
		return "category postAdd completed: categoryId=" + category.getId();
	}

	/**
	 * 删除一个分类 TODO 权限
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public
	@ResponseBody
	String postDelete(Integer categoryId, Map<String, Object> model) {
		categoryService.delete(categoryId);
		return "category postDelete completed: categoryId=" + categoryId;
	}

}

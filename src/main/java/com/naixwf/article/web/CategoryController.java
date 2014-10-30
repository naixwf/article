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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naixwf.article.service.HelloWorldService;

import java.util.Date;
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

	@Autowired
	private HelloWorldService helloWorldService;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "abc");
		return "index";
	}
}

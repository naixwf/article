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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * 角色相关入口
 * 角色表直接在数据库中维护，暂不提供维护页面
 * 题目(4) 查看权限的管理
 *
 * TODO
 * 调整人员的角色
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	/**
	 * 用户-角色列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String list(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "abc");
		return "index";
	}

	/**
	 * 修改某人的角色
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public
	@ResponseBody
	String postEdit(Integer userId, Integer roleId, Map<String, Object> model) {
		//TODO stub 重定向到view
		return null;
	}
}

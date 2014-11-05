package com.naixwf.article.web;

import com.naixwf.article.define.AuthorityDefine;
import com.naixwf.article.domain.Authority;
import com.naixwf.article.service.AuthorityService;
import com.naixwf.article.service.UserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户、角色相关入口
 * 角色表直接在数据库中维护，暂不提供维护页面
 * 题目(4) 查看权限的管理
 *
 * 调整人员的角色
 *
 * 权限：只有ROLE_ADMIN可以使用
 */
@Controller
@RequestMapping("/user")
@Secured({ "ROLE_ADMIN" })
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private AuthorityService authorityService;

	/**
	 * 用户-角色列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String list(Map<String, Object> model) {
		Map<String, String> authorityDefineMap = AuthorityDefine.getMap();
		model.put("authorityDefineMap", authorityDefineMap);

		List<Authority> list = authorityService.getAll();
		model.put("authorityList", list);

		return "user/list";
	}

	/**
	 * 修改某人的角色
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(String username, String authority) {
		authorityService.modify(username, authority);
		return "redirect:/user";
	}
}

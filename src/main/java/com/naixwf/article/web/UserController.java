package com.naixwf.article.web;

import com.naixwf.article.domain.User;
import com.naixwf.article.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户、角色相关入口
 * 角色表直接在数据库中维护，暂不提供维护页面
 * 题目(4) 查看权限的管理
 *
 * TODO
 * 调整人员的角色
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;

	/**
	 * 用户-角色列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String list(Map<String, Object> model) {
		List<User> list = userService.getAll();
		model.put("userList", list);
		return "user/list";
	}

	/**
	 * 修改某人的角色
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public
	@ResponseBody
	String postEdit(Integer userId, Integer roleId) {
		userService.modifyRole(userId, roleId);
		return "postEdit user role completed: userId=" + userId;
	}
}

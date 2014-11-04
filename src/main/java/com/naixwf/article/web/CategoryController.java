package com.naixwf.article.web;

import com.naixwf.article.domain.Category;
import com.naixwf.article.service.CategoryService;
import org.springframework.security.access.annotation.Secured;
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
 *
 * 分类列表
 * 新增分类
 * 修改分类
 * 删除分类
 *
 * 权限：只有ROLE_ADMIN可以访问
 */
//@Secured({ "ROLE_ADMIN" }) TODO for debug
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
	public String
	postAdd(Category category) {
		//TODO 过滤恶意脚本  防CSRF
		categoryService.add(category);
		return "redirect:/category";
	}

	/**
	 * 修改一个分类
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(Category category) {
		categoryService.modify(category);
		return "redirect:/category";
	}

	/**
	 * 删除一个分类
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postDelete(Integer categoryId) {
		//TODO 先查一下有没有article在用这个类别，如果有，则不允许删除
		categoryService.delete(categoryId);
		return "redirect:/category";
	}

}

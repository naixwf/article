package com.naixwf.article.web;

import com.naixwf.article.domain.Article;
import com.naixwf.article.domain.Category;
import com.naixwf.article.service.ArticleService;
import com.naixwf.article.service.CategoryService;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

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
@Secured({ "ROLE_ADMIN" })
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
	@Resource
	private CategoryService categoryService;
	@Resource
	private ArticleService articleService;

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
	public String postAdd(Category category) {
		Validate.notNull(category, "参数不能全部为空");
		Validate.notBlank(category.getCategroyName(), "类别名称不能为空");

		categoryService.add(category);
		return "redirect:/category?info=" + urlEncode("添加文档分类【%s】成功", category.getCategroyName());
	}

	/**
	 * 修改一个分类
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(Category category) {
		Validate.notNull(category, "参数不能全部为空");
		Validate.notNull(category.getId(), "id不能为空");
		Validate.notBlank(category.getCategroyName(), "类别名称不能为空"); //TODO 还应该限制长度

		categoryService.modify(category);
		return "redirect:/category?info=" + urlEncode("修改文档分类【%s】成功", category.getCategroyName());
	}

	/**
	 * 删除一个分类
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postDelete(Integer categoryId) {
		Validate.notNull(categoryId, "categoryId不能为空");

		List<Article> articleList = articleService.getListByCategoryId(categoryId);
		if (!CollectionUtils.isEmpty(articleList)) {
			return "redirect:/category?info=" + urlEncode("该分类下有%d篇文档，不允许删除", articleList.size());
		}

		categoryService.delete(categoryId);
		return "redirect:/category?info=" + urlEncode("删除文档分类成功");
	}

}

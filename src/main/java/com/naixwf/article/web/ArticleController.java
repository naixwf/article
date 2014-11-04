package com.naixwf.article.web;

import com.naixwf.article.SecretLevel;
import com.naixwf.article.domain.Article;
import com.naixwf.article.domain.ArticleWithBLOBs;
import com.naixwf.article.service.ArticleService;
import com.naixwf.article.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	@Resource
	private ArticleService articleService;
	@Resource
	private CategoryService categoryService;

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
		model.put("secretLevelMap", SecretLevel.getSecretLevelMap());
		model.put("categoryMap", categoryService.getCategoryMap());

		Article article = articleService.getById(articleId);
		model.put("article", article);
		return "article/view";
	}

	/**
	 * 新增一篇文章
	 */
	//	@Secured({ "ROLE_ADMIN" })    TODO for debug
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Map<String, Object> model) {
		model.put("secretLevelMap", SecretLevel.getSecretLevelMap());
		model.put("categoryMap", categoryService.getCategoryMap());
		return "article/add";
	}

	//	@Secured({ "ROLE_ADMIN" })    TODO for debug
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(ArticleWithBLOBs article) {
		//TODO validate param
		articleService.add(article);
		return "redirect:view?articleId=" + article.getId();
	}

	/**
	 * 修改一篇文章
	 */
	//	@Secured({ "ROLE_ADMIN" })   TODO for debug
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer articleId, Map<String, Object> model) {
		model.put("secretLevelMap", SecretLevel.getSecretLevelMap());
		model.put("categoryMap", categoryService.getCategoryMap());

		Article article = articleService.getById(articleId);
		model.put("article", article);
		return "article/edit";
	}

	//	@Secured({ "ROLE_ADMIN" })    TODO for debug
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(ArticleWithBLOBs article) {
		articleService.modify(article);
		return "redirect:view?articleId=" + article.getId();
	}

	/**
	 * 删除一篇文档
	 */
	//	@Secured({ "ROLE_ADMIN" })       TODO for debug
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postDelete(Integer articleId) {
		articleService.delete(articleId);
		return "redirect:/article";//TODO contextPath
	}

}

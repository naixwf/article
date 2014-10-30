package com.naixwf.article.web;

import com.naixwf.article.domain.Article;
import com.naixwf.article.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	/**
	 * 文章列表
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String list(Map<String, Object> model) {
		List<Article> list = articleService.getAll();
		model.put("articleList", list);
		LOGGER.debug("articleController.list invoked");
		return "article/list";
	}

	/**
	 * 查看一篇文章
	 */
	@RequestMapping("/view")
	public String view(Integer articleId, Map<String, Object> model) {
		Article article = articleService.getById(articleId);
		model.put("article", article);
		return "article/view";
	}

	/**
	 * 新增一篇文章
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Map<String, Object> model) {
		return "article/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(Article article) {
		//TODO validate param
		articleService.add(article);
		return "redirect:view?articleId=" + article.getId();
	}

	/**
	 * 修改一篇文章
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer articleId, Map<String, Object> model) {
		Article article = articleService.getById(articleId);
		model.put("article", article);
		return "article/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(Article article) {
		articleService.modify(article);
		return "redirect:view?articleId=" + article.getId();
	}

	/**
	 * 删除一篇文档
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postDelete(Integer articleId) {
		articleService.delete(articleId);
		return "redirect:/article";//TODO contextPath
	}

}

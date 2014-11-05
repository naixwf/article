package com.naixwf.article.web;

import com.naixwf.article.define.AuthorityDefine;
import com.naixwf.article.define.SecretLevel;
import com.naixwf.article.domain.Article;
import com.naixwf.article.domain.ArticleWithBLOBs;
import com.naixwf.article.exception.BizException;
import com.naixwf.article.service.ArticleService;
import com.naixwf.article.service.CategoryService;
import org.apache.commons.lang3.Validate;
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
 *
 * 文档列表
 * 新增文档
 * 修改文档
 * 删除文档
 */
@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	@Resource
	private ArticleService articleService;
	@Resource
	private CategoryService categoryService;

	/**
	 * 文章列表
	 * AUTH 有数据权限控制
	 * @param model
	 * @return
	 */
	@RequestMapping
	public String list(Map<String, Object> model) {
		int currentUserSecretLevel = AuthorityDefine.getCurrentUserSecretLevel();

		List<Article> list = articleService.getListLowerThanSecretLevel(currentUserSecretLevel);
		model.put("secretLevelMap", SecretLevel.getSecretLevelMap());
		model.put("articleList", list);

		//TODO 分页

		return "article/list";
	}

	/**
	 * 查看一篇文章
	 * AUTH 有数据权限控制
	 */
	@RequestMapping("/view")
	public String view(Integer articleId, Map<String, Object> model) {
		Validate.notNull(articleId, "参数articleId不能为空");

		model.put("secretLevelMap", SecretLevel.getSecretLevelMap());
		model.put("categoryMap", categoryService.getCategoryMap());

		Article article = articleService.getById(articleId);

		if (article == null) {
			throw new BizException("没有找到此文章,id=" + articleId);
		}

		model.put("article", article);
		return "article/view";
	}

	/**
	 * 新增一篇文章
	 */
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Map<String, Object> model) {
		model.put("secretLevelMap", SecretLevel.getSecretLevelMap());
		model.put("categoryMap", categoryService.getCategoryMap());
		return "article/add";
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String postAdd(ArticleWithBLOBs article) {
		Validate.notNull(article, "参数不能全部为空");
		Validate.notBlank(article.getTitle(), "标题不能为空");
		Validate.notBlank(article.getContent(), "内容不能为空");
		Validate.notNull(article.getCategoryId(), "类别不能为空");
		Validate.notNull(article.getSecretLevel(), "安全级别不能为空");

		articleService.add(article);
		return "redirect:view?articleId=" + article.getId() + "&info=" + urlEncode("新增文档成功");
	}

	/**
	 * 修改一篇文章
	 */
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Integer articleId, Map<String, Object> model) {
		Validate.notNull(articleId, "参数articleId不能为空");

		model.put("secretLevelMap", SecretLevel.getSecretLevelMap());
		model.put("categoryMap", categoryService.getCategoryMap());

		Article article = articleService.getById(articleId);
		model.put("article", article);
		return "article/edit";
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String postEdit(ArticleWithBLOBs article) {
		Validate.notNull(article, "参数不能全部为空");
		Validate.notNull(article.getId(), "id不能为空");
		Validate.notBlank(article.getTitle(), "标题不能为空");
		Validate.notBlank(article.getContent(), "内容不能为空");
		Validate.notNull(article.getCategoryId(), "类别不能为空");
		Validate.notNull(article.getSecretLevel(), "安全级别不能为空");

		articleService.modify(article);
		return "redirect:view?articleId=" + article.getId() + "&info=" + urlEncode("修改文档成功");
	}

	/**
	 * 删除一篇文档
	 */
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postDelete(Integer articleId) {
		Validate.notNull(articleId, "articleId不能为空");

		articleService.delete(articleId);
		return "redirect:/article?info=" + urlEncode("删除文档成功");
	}

}

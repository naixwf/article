package com.naixwf.article.service;

import com.naixwf.article.domain.Category;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfei on 14-10-30.
 * 文档类别管理service
 */
public interface CategoryService {
	/**
	 * 得到所有类别信息
	 * @return
	 */
	List<Category> getAll();

	/**
	 * 新增一个类别
	 * @param category
	 */
	void add(Category category);

	/**
	 * 修改一个类别
	 * @param category
	 */
	void modify(Category category);

	/**
	 * 删除一个类别
	 * @param categoryId
	 */
	void delete(int categoryId);

	/**
	 * 获取所有类别 key->value
	 * @return
	 */
	Map<String, String> getCategoryMap();

}

package com.naixwf.article.service.impl;

import com.naixwf.article.domain.Category;
import com.naixwf.article.domain.CategoryExample;
import com.naixwf.article.persistence.CategoryMapper;
import com.naixwf.article.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangfei on 14-10-30.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> getAll() {
		CategoryExample e = new CategoryExample();

		List<Category> list = categoryMapper.selectByExample(e);
		if (CollectionUtils.isEmpty(list)) {
			list = Collections.EMPTY_LIST;
		}

		return list;
	}

	@Override
	public void add(Category category) {
		categoryMapper.insert(category);
	}

	@Override
	public void modify(Category category) {
		categoryMapper.updateByPrimaryKeySelective(category);
	}

	@Override
	public void delete(int categoryId) {
		categoryMapper.deleteByPrimaryKey(categoryId);
	}

	@Override
	public Map<String, String> getCategoryMap() {
		List<Category> list = getAll();
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (Category c : list) {
			map.put(c.getId().toString(), c.getCategroyName());
		}
		return map;
	}
}

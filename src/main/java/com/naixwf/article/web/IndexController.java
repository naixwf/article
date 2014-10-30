package com.naixwf.article.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by wangfei on 14-10-30.
 * 首页
 */
@Controller
public class IndexController {

	/**
	 * 首页
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(Map<String, Object> model) {
		return "redirect:/article";
	}
}

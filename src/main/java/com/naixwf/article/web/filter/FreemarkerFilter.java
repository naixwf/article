package com.naixwf.article.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by wangfei on 14-11-4.
 * 这个filter处理sitemeshFilter处理之后的结果
 * 作用是把装饰器里的freemarker渲染一下
 */
public class FreemarkerFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(FreemarkerFilter.class);
	private FreeMarkerViewResolver freeMarkerViewResolver;

	public FreemarkerFilter(FreeMarkerViewResolver resolver) {
		this.freeMarkerViewResolver = resolver;
	}

	private Locale locale;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String localeStr = filterConfig.getInitParameter("locale");
		if (!StringUtils.isEmpty(localeStr)) {
			locale = new Locale(localeStr);
		} else {
			locale = Locale.getDefault();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			String name = req.getRequestURI();

			name = name.substring(1, name.lastIndexOf(".ftl"));

			View view = freeMarkerViewResolver.resolveViewName(name, locale);

			view.render(null, req, res);
		} catch (Exception e) {
			LOGGER.error("", e);
			throw new ServletException(e);
		}
	}

	@Override
	public void destroy() {
	}
}

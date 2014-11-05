package com.naixwf.article;

import com.naixwf.article.web.interceptor.AccessLogInterceptor;
import com.naixwf.article.web.interceptor.ControllerInfoInterceptor;
import com.naixwf.article.web.filter.FreemarkerFilter;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.Resource;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangfei on 14-10-30.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	@Resource
	private FreeMarkerViewResolver freeMarkerViewResolver;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AccessLogInterceptor());
		registry.addInterceptor(new ControllerInfoInterceptor());
	}

	@Bean
	public FilterRegistrationBean sitemeshFilter() {
		Filter sitemeshFilter = new ConfigurableSiteMeshFilter();

		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(sitemeshFilter);

		return filterRegBean;
	}

	/**
	 * 这个filter用来在sitemesh处理过之后，再处理一下装饰模板中的freemarker部分
	 * @return
	 */
	@Bean
	public FilterRegistrationBean freemarkerFilter() {
		Filter freemarkerFilter = new FreemarkerFilter(freeMarkerViewResolver);

		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(freemarkerFilter);

		Set<String> urlPatterns = new HashSet<String>();
		urlPatterns.add("*.ftl");
		filterRegBean.setUrlPatterns(urlPatterns);

		filterRegBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);

		return filterRegBean;
	}

}

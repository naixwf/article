/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.naixwf.article;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)//TODO why exclude
@ComponentScan
@MapperScan("com.naixwf.article.persistence")
public class ArticleApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ArticleApplication.class, args);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean
				.setMapperLocations(resolver.getResources("classpath:com/naixwf/article/persistence/*.xml"));

		return sqlSessionFactoryBean.getObject();
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {

		Properties properties = new Properties();
		String url = "jdbc:mysql://localhost/article";
		properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "87654312");
		properties.setProperty("useUnicode", "true");
		properties.setProperty("characterEncoding", "UTF8");

		//druid via https://github.com/alibaba/druid/wiki/%E9%A6%96%E9%A1%B5
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl(url);
		ds.setConnectProperties(properties);

		return ds;
	}

	@Bean
	public FilterRegistrationBean sitemeshFilter() {
		Filter sitemeshFilter = new ConfigurableSiteMeshFilter();

		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(sitemeshFilter);

		return filterRegBean;
	}

}

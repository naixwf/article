package com.naixwf.article;

import com.naixwf.article.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by wangfei on 14-10-30.
 */
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers(
						"/bower_components/**", "/appstatic/**",//静态资源不做权限校验
						"/", "/article", "/article/view",//特定路径不做权限校验
						"/favicon.ico"
				)
				.permitAll()
				.anyRequest().authenticated();
//				hasAnyAuthority("ROLE_ANONYMOUS","ROLE_ADMIN","ROLE_JUNIOR","ROLE_SENIOR");//TODO 可维护性
		http
				.formLogin()
				.loginPage("/login").defaultSuccessUrl("/article").permitAll()
				.and()
				.logout()
				.permitAll();

		http
				.csrf().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(this.dataSource);
	}

}
package com.naixwf.article;

import com.naixwf.article.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.net.URLEncoder;

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

		http.authorizeRequests()
				.antMatchers("/bower_components/**", "/appstatic/**",//静态资源不做权限校验
						"/", "/article", "/article/view",//特定路径不做权限校验
						"/favicon.ico",
						"/login"
				).permitAll()
				.anyRequest().fullyAuthenticated()
				.and().formLogin().loginPage("/login")
				.failureUrl("/login?info=" + URLEncoder.encode("用户名或密码错误", "utf-8"))
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		//				.and().exceptionHandling().accessDeniedPage("/access");//TODO 异常处理目前没有细分，全部导向error view
		//TODO 这里为了方便开发，没有打开csrf，后续应该加上
		http
				.csrf().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(this.dataSource);
	}

}
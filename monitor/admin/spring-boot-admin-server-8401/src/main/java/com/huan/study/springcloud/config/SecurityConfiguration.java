package com.huan.study.springcloud.config;

import de.codecentric.boot.admin.config.AdminServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * spring security 配置
 *
 * @author huan.fu
 * @date 2018/6/20 - 11:46
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AdminServerProperties adminServerProperties;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		String contextPath = adminServerProperties.getContextPath();

		http.formLogin().loginPage(contextPath + "/login.html").loginProcessingUrl(contextPath + "/login").defaultSuccessUrl(contextPath+"/").permitAll();
		http.logout().logoutUrl(contextPath + "/logout");
		http.csrf().disable();

		http.authorizeRequests()
				.antMatchers(contextPath + "/login.html", "/**/*.css", contextPath + "/img/**", contextPath + "/third-party/**")
				.permitAll();
		http.authorizeRequests().antMatchers("/**").authenticated();

		http.httpBasic();
	}
}

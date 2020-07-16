package com.intecsec.mall.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author peter.peng
 * @date 2020/7/15
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//关闭csrf
		http.csrf().disable();
		// 开启认证
		// http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		super.configure(http);
	}
}

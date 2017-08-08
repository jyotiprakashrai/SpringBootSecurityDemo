package com.sboot.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String ADMIN = "ADMIN";
	private static final String USER = "USER";

	@Override
	public void configure(HttpSecurity httpScurity) throws Exception {
		httpScurity.authorizeRequests().antMatchers("/svc/v1/private/accounts/**").hasRole(USER)
		.antMatchers("/svc/v1/private/admin/**").hasRole(ADMIN)
		.and().formLogin();

	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("jyoti").password("password").roles(USER).and().withUser("prakash")
				.password("password").roles(USER, ADMIN);

	}
	
	

}

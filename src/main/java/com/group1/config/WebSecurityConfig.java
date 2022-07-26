package com.group1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.group1.entities.user.CustomUserDetail;
import com.group1.entities.user.CustomUserDetailService;
//import com.group1.entities.user.;
/*
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	//@Autowired
	//private DataSource dataSource;

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/admin/**").hasAuthority("1")
			.anyRequest().permitAll()
			.and().formLogin()
				.loginPage("/admin/login")
				.usernameParameter("userName")
				.passwordParameter("password")
				.loginProcessingUrl("/admin/loginAction")
				.defaultSuccessUrl("/admin/home")
				.permitAll()
			.and().logout().logoutSuccessUrl("/").permitAll();
		http.csrf().disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web
		.ignoring()
		.antMatchers("/resources/**", "/static/**");
	}
}*/
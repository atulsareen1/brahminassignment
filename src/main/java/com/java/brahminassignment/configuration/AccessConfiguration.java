package com.java.brahminassignment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@EnableWebSecurity
public class AccessConfiguration extends WebSecurityConfigurerAdapter{
	public static final String[] PROTECTED_RESOURCES = new String[] {"/statement/list"};
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Setting users and their roles
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN")
		.and()
		.withUser("user").password("password").roles("USER")
		.and()
		.withUser("test").password("password").roles("TEST");
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().maximumSessions(1);
		http.authorizeRequests()
		.antMatchers("/statement/list").hasAnyRole("ADMIN","USER","TEST")
		.antMatchers("/*").hasRole("ADMIN").and().formLogin();
	}
}

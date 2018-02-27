package com.lys.zhku.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.lys.zhku.mapper.AuthoritiesMapper;
import com.lys.zhku.mapper.UsersMapper;
import com.lys.zhku.security.userdetails.ZhkuUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsersMapper usersMapper;
	
	@Autowired
	private AuthoritiesMapper authoritiesMapper;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new ZhkuUserDetailsService(usersMapper,authoritiesMapper))
			.passwordEncoder(new StandardPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.headers().frameOptions().sameOrigin()
		//.and().csrf().disable()
		.and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/index")
		.and()
		.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/home").hasAuthority("user");
	}
	
}

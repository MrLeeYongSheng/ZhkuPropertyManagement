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
import com.lys.zhku.utils.Authorities;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private AuthoritiesMapper authoritiesMapper;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new ZhkuUserDetailsService(usersMapper, authoritiesMapper))
				.passwordEncoder(new StandardPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 配置登录信息
		http.headers().frameOptions().sameOrigin().and().csrf().disable()
				// .and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/index").and().authorizeRequests()
				.antMatchers("/login").permitAll().antMatchers("/", "/index")
				.hasAnyAuthority(Authorities.user.getAuth());
		// end 配置登录信息

		// 配置主页面
		http.authorizeRequests().antMatchers("/json/menu/menu_user_*.json")// 普通用户可以获取的菜单
				.hasAuthority(Authorities.user.getAuth())// 普通用户权限
				.regexMatchers("/json/menu/menu_[1-9]{1,}.json")// 管理员可以获取的菜单
				.hasAuthority(Authorities.admin.getAuth());// 管理员的权限
		// end 配置主页面


/*		// 配置宿舍,教室,文件下载,获取学生信息页面(学生可访问页面)
		http.authorizeRequests().antMatchers("/school/dormitory/main", "/school/dormitory/detail", // 宿舍
				"/school/classroom", // 教室
				"/files", // 文件
				"/students/*")// 学生
				.hasAnyAuthority(Authorities.user.getAuth());// 宿舍,教室,文件下载,获取学生信息
		// end 配置宿舍,教室,文件下载,获取学生信息页面(学生可访问页面)
*/
		// 全局配置
		http.authorizeRequests().antMatchers("/static/**").permitAll();//将静态资源放出去
		// end 全局配置
	}

}

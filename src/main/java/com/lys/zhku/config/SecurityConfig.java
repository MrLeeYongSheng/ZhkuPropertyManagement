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
		http.headers().frameOptions().sameOrigin().and().csrf().disable().formLogin().loginPage("/login")
				.defaultSuccessUrl("/index").and().authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers("/", "/index").hasAnyAuthority(Authorities.user.getAuth());
		// end 配置登录信息

		// 配置主页面
		http.authorizeRequests().antMatchers("/json/menu/menu_user_*.json")// 普通用户可以获取的菜单
				.hasAuthority(Authorities.user.getAuth())// 普通用户权限
				.regexMatchers("/json/menu/menu_[1-9]{1,}.json")// 管理员可以获取的菜单
				.hasAuthority(Authorities.admin.getAuth());// 管理员的权限
		// end 配置主页面

		// 配置宿舍,教室,文件下载,获取学生信息页面(学生可访问页面)
		http.authorizeRequests().antMatchers("/school/dormitory/detail", // 宿舍主页面 // 学生用户查询宿舍模块
				"/students/getDormitoryStudentsByUsersUsername", "/students/exportSelections", // 获取/导出学生用户宿舍成员信息
				"/remote/waterElectricity/dormitory/weChargeByUsername",//获取水电费账单
				// end 学生用户查询宿舍模块
				// 学生用户查询教室模块
				"/school/classroom/main", "/school/classroom/getPage", // 获取教室列表
				"/school/classroom/exportSelections", "/school/classroom/exportAll", // 导出教室列表
				"/school/classroom/schedule/main", "/school/classroom/schedule/getPage", // 获取教室安排表
				"/school/classroom/schedule/exportSelections", "/school/classroom/schedule/exportAll", // 导出安排表
				"/school/classroom/schedule/edit", // 预约教室(修改安排表记录)
				// end 学生用户查询教室模块
				// 文件查询,导出模块
				"/files/main", "/files/getPage", "/files/exportSelections", "/files/exportAll")
				.hasAnyAuthority(Authorities.user.getAuth());
		// end 配置宿舍,教室,文件下载,获取学生信息页面(学生可访问页面)

		// 系统首页配置
		http.authorizeRequests().antMatchers(
				"/subviews/portal/index",//系统首页界面
				"/subviews/user/modifyPassword", "/home/modifyPassword", // 修改密码
				// 个人信息
				"/subviews/user/infoDetail", "/students/getByUsersUsername", // 获取个人信息
				"/userdetails/getUserdetailsByUsersUsername", "/userdetails/edit",// 修改
				// end 个人信息
				//头像
				"/subviews/user/headPicture","/subviews/user/headPicture_main",//获取上传页面,管理页面
				"/personalFiles/getPage","/personalFiles/delete",//获取分页,删除操作
				"/personalFiles/download","/personalFiles/uploadHeadPicture"//下载操作,上传操作
				//end 头像
		).hasAnyAuthority(Authorities.user.getAuth());
		// end 系统首页配置

		// 全局配置
		http.authorizeRequests().antMatchers("/topjui/**", "/html/**", "/json/**", "/static/**", // topUi组件
				"/jquery-easyui-*/**", "/jspf/**", "/css/**", "/js/**").permitAll();// 将静态资源放出去
		http.authorizeRequests().antMatchers("/**").hasAnyAuthority(Authorities.admin.getAuth());// 默认所有资源需要管理员权限
		// end 全局配置
	}

}

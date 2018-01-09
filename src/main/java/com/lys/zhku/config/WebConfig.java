package com.lys.zhku.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc // 开启web MVC
@ComponentScan(basePackages = "com.lys.zhku.web")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 注册ViewResolvers
		InternalResourceViewResolver resolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
		//InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);// 支持JSTL模板
		registry.viewResolver(resolver);
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();// 让Servlet容器默认的Servlet处理静态资源的请求,而不是使用DispatcherServlet来处理
							// 让webapp/文件夹下的非/WEB-INF/文件夹的容可得到处理
							//DispatcherServlet无法处理的url交给默认的Servlet处理
	}
/*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	//用来映射静态资源,可映射/WEB-INF/文件夹的内容
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/views/");
	}
*/
}

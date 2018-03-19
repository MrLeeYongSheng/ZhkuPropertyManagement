package com.lys.zhku.initializer;

import java.io.File;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.lys.zhku.config.RootConfig;
import com.lys.zhku.config.WebConfig;
import com.lys.zhku.utils.PropertiesUtils;

public class WebMvcApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		//编码过滤器 UTF-8, 默认映射despatcherServlet的路径
		return new Filter[] {new CharacterEncodingFilter("UTF-8", true)};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		try {
			String fileName = this.getClass().getClassLoader().getResource("com/lys/zhku/config/webapp.porperties").getPath();
			PropertiesUtils.use(fileName);
			String path = PropertiesUtils.get("uploadTempPath");
			File dir = new File(path);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			if(!dir.canWrite()) {
				dir.setWritable(true);
			}
			if(!dir.canRead()) {
				dir.setReadable(true);
			}
			MultipartConfigElement multipartConfig = new MultipartConfigElement(path);
			registration.setMultipartConfig(multipartConfig);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.customizeRegistration(registration);
	}

}

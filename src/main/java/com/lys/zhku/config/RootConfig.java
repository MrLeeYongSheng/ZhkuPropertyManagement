package com.lys.zhku.config;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.waterelectricity.we.service.WaterElectricityService;

/**
 * <p>Spring的全局配置</p>
 * @author MrLeeYongSheng
 */
@Configuration
@ComponentScan(basePackages = "com.lys.zhku", excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = { EnableWebMvc.class, Controller.class }) })
@ImportResource("classpath:com/lys/zhku/config/applicationContext-tx.xml")
@EnableAspectJAutoProxy //开启切面代理
@PropertySource(value="classpath:com/lys/zhku/config/webapp.porperties", encoding="UTF-8")
public class RootConfig {
	
	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {

		// 使用Spring JDBC自带的数据源
		// DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		// 使用Mybatis的连接池数据源
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver(env.getProperty("jdbc.driver"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}

	/**
	 * <p>MyBatis的配置交给Spring来定义,就在本方法里定义</p>
	 * <p>Mapper.xml的扫描交给{@link #mapperScannerConfigurer()}</p>
	 * @param dataSource
	 * @return
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		// 设置mybatis的配置
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		//configuration.setLogImpl(Log4j2LoggerImpl.class); //让其自动扫描,使用Spring应用原来配置的Log4J
		configuration.setCacheEnabled(true);// 启用二级缓存
		configuration.setMapUnderscoreToCamelCase(true);// 表字段匹配model属性,下划线转驼峰规则
		configuration.setAggressiveLazyLoading(false);// 避免model的延迟加载属性受其他属性的调用而触发全加载
		sqlSessionFactory.setConfiguration(configuration);
		// 设置DataSource
		sqlSessionFactory.setDataSource(dataSource);
		// sqlSessionFactory.setMapperLocations(mapperLocations);将Mapper.xml的扫描交给"扫描接口组件"来默认扫描
		return sqlSessionFactory;
	}
	

	/**
	 * <p>扫描Mapper接口</p>
	 * <p>扫描出来的接口,会使用动态代理实现其实现类,并作为Bean放在Spring容器</p>
	 * <p>默认会去扫描Mapper.xml,扫描规则是:将接口的全限定名的"."改为"/",再在最后添加".xml"</p>
	 * @return
	 */
	@Bean
	public static MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.lys.zhku.mapper");
		return mapperScannerConfigurer;
	}
	
	@Bean
	public HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean() {
		HttpInvokerProxyFactoryBean bean = new HttpInvokerProxyFactoryBean();
		bean.setServiceInterface(WaterElectricityService.class);
		bean.setServiceUrl("http://localhost:8080/we/remote/serviceExporter");
		return bean;
	}
}

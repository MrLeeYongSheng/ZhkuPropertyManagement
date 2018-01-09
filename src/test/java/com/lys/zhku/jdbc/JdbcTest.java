package com.lys.zhku.jdbc;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lys.zhku.config.RootConfig;
import com.lys.zhku.jdbc.config.JdbcConfig;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=JdbcConfig.class)
public class JdbcTest {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void test() {
		assertNotNull(dataSource);
	}

}

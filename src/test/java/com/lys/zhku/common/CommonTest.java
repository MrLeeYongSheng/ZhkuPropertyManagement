package com.lys.zhku.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lys.zhku.config.RootConfig;
import com.lys.zhku.model.Datadict;
import com.lys.zhku.model.Park;
import com.lys.zhku.utils.CollectionUtils;
import com.lys.zhku.utils.FileUtils;
import com.lys.zhku.utils.PropertiesUtils;

//@RunWith(value=SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=RootConfig.class)
public class CommonTest {
	
	private static Logger log = Logger.getLogger(CommonTest.class);

	//@Autowired
	//Environment env;
	
	@Test
	public void test() throws Exception {

		
	}
	
	
	
	private final static String s = "a";
	
	@Test
	public void testProperties() throws Exception {
		 System.out.println("ccc"+s);
		
	}

	@Test
	public void testTx() {
		assertEquals(true, CollectionUtils.isEmpty(new ArrayList<>()));

	}

	@Test
	public void testSet() {
		Park park = new Park();
		park.setEnable(true);
		park.setBook(true);
		park.setEntryTime(new Date());
		park.setCampus("");
		park.setSiteNum("");
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Park>> validate = validator.validate(park);
		System.out.println(validate.size());
	}

	@Test
	public void testSimpleGrantedAuthority() {
		assertEquals(new SimpleGrantedAuthority("a"), new SimpleGrantedAuthority("a"));
	}
}

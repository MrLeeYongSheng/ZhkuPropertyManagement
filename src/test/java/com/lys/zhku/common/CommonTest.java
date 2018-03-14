package com.lys.zhku.common;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.lys.zhku.utils.CollectionUtils;

//@RunWith(value=SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=RootConfig.class)
public class CommonTest {
	

	
	@Test
	public void testTx() {
		assertEquals(true,CollectionUtils.isEmpty(new ArrayList<>()));
	}
	
	@Test
	public void test() {
		StandardPasswordEncoder se = new StandardPasswordEncoder();
		String encode = se.encode("123456");
		System.out.println(se.matches("123456", encode));
		System.out.println(encode);
	}//b707e2640a78bc251a877f3d77210084a528ef931ce908f4ee78f3508dae7546b227baa3608e30ee
	
	@Test
	public void testSet() {
		Set<String> set = new HashSet<>();
		set.add("a");
		set.add("a");
		assertEquals(1, set.size());
	}
	
	@Test
	public void testSimpleGrantedAuthority() {
		assertEquals(new SimpleGrantedAuthority("a"), new SimpleGrantedAuthority("a"));
	}
}

package com.lys.zhku.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.ibatis.type.JdbcType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lys.zhku.aop.CommonServicesAspect;
import com.lys.zhku.config.RootConfig;
import com.lys.zhku.mapper.AuthoritiesMapper;
import com.lys.zhku.mapper.ClassroomMapper;
import com.lys.zhku.mapper.ClassroomScheduleMapper;
import com.lys.zhku.mapper.DatadictMapper;
import com.lys.zhku.mapper.DormitoryMapper;
import com.lys.zhku.mapper.FilesMapper;
import com.lys.zhku.mapper.ParkMapper;
import com.lys.zhku.mapper.RolesAuthoritiesMapper;
import com.lys.zhku.mapper.RolesMapper;
import com.lys.zhku.mapper.StudentsMapper;
import com.lys.zhku.mapper.UserdetailsMapper;
import com.lys.zhku.mapper.UsersMapper;
import com.lys.zhku.mapper.UsersRolesMapper;
import com.lys.zhku.mapper.WorkersMapper;
import com.lys.zhku.model.Authorities;
import com.lys.zhku.model.Classroom;
import com.lys.zhku.model.ClassroomSchedule;
import com.lys.zhku.model.Datadict;
import com.lys.zhku.model.Files;
import com.lys.zhku.model.Park;
import com.lys.zhku.model.Roles;
import com.lys.zhku.model.Students;
import com.lys.zhku.model.Users;
import com.lys.zhku.model.UsersRoles;
import com.lys.zhku.pojo.web.Pagination;
import com.lys.zhku.pojo.web.StudentsPagination;
import com.lys.zhku.security.userdetails.ZhkuUserDetails;
import com.lys.zhku.security.userdetails.ZhkuUserDetailsService;
import com.lys.zhku.utils.PropertiesUtils;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class JdbcTest {

	@Autowired
	DataSource dataSource;
	@Autowired
	AuthoritiesMapper authoritiesMapper;
	@Autowired
	RolesMapper rolesMapper;
	@Autowired
	RolesAuthoritiesMapper rolesAuthoritiesMapper;
	@Autowired
	UsersMapper usersMapper;
	@Autowired
	UsersRolesMapper usersRolesMapper;

	@Autowired
	UserdetailsMapper userdetailsMapper;
	@Autowired
	StudentsMapper studentsMapper;
	@Autowired
	WorkersMapper workersMapper;

	DatadictMapper datadictMapper;
	
	@Autowired
	DormitoryMapper dormitoryMapper;
	
	@Autowired
	ClassroomMapper classroomMapper;
	
	@Autowired
	ClassroomScheduleMapper classroomScheduleMapper;
	
	@Autowired
	ParkMapper<Park> parkMapper;
	
	@Autowired
	FilesMapper filesMapper;
	
	@Test
	public void testMapper() throws Exception {
		List<String> list = filesMapper.selectUuidNameByPrimaryKeys(null);

	}
	
	@Test
	public void testLogin() {
		Users user = usersMapper.selectByPrimaryKey("admin");
		assertNotNull(user);
		List<UsersRoles> usersRoles = usersRolesMapper.selectByUsersUsername(user.getUsername());
		assertNotNull(usersRoles);
		List<Roles> rolesList = rolesMapper.selectByUsersRolesList(usersRoles);
		assertNotNull(rolesList);
	}
	
	@Test
	public void testAuthorities() {
		List<Authorities> list = authoritiesMapper.selectByUsersUsername("admin");
		assertEquals(3, list.size());
		
	}
	
	@Test
	public void testMapperList() {
		List<Authorities> list = authoritiesMapper.selectByUsersUsername("abc");
		assertNotNull(list);
		assertEquals(0, list.size());
	}
	
	protected Collection<GrantedAuthority> loadAuthorities(String username) {
		List<Authorities> authorities = authoritiesMapper.selectByUsersUsername(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>(authorities.size());
		for (Authorities authority : authorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
		}
		return grantedAuthorities;
	}
	
	@Test
	public void testLoadAuthorities() {
		Collection<GrantedAuthority> loadAuthorities = loadAuthorities("admin");
		assertEquals(2, loadAuthorities.size());
		
	}
	
	@Test
	public void testZhkuUserDetailsService() {
		ZhkuUserDetailsService d = new ZhkuUserDetailsService(usersMapper, authoritiesMapper);
		ZhkuUserDetails userDetails = (ZhkuUserDetails) d.loadUserByUsername("admin");
		assertEquals("admin", userDetails.getUsername());
		assertEquals("管理员", userDetails.getNickname());
		assertEquals(2, userDetails.getAuthorities().size());
		
	}
	
	@Test
	public void testTable() {
		assertNotNull(usersMapper);
		String expected = "201420214421";
		Users user = usersMapper.selectByPrimaryKey(expected);
		assertNotNull(user);
		if(user!=null)
			assertEquals(expected, user.getUsername());
	}

}

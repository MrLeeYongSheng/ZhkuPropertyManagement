package com.lys.zhku.security.userdetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lys.zhku.mapper.AuthoritiesMapper;
import com.lys.zhku.mapper.UsersMapper;
import com.lys.zhku.model.Authorities;
import com.lys.zhku.model.Users;

public class ZhkuUserDetailsService implements UserDetailsService {

	protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
	protected final Log logger = LogFactory.getLog(getClass());

	private UsersMapper usersMapper;// 查询用户是否存在
	private AuthoritiesMapper authoritiesMapper;// 查询权限

	public ZhkuUserDetailsService(UsersMapper usersMapper, AuthoritiesMapper authoritiesMapper) {
		super();
		this.usersMapper = usersMapper;
		this.authoritiesMapper = authoritiesMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersMapper.selectByPrimaryKey(username);
		if (user == null) {
			this.logger.debug("Query returned no results for user '" + username + "'");
			throw new UsernameNotFoundException(this.messages.getMessage("ZhkuUserDetailsService.notFound",
					new Object[] { username }, "Username {0} not found"));
		}

		Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();

		dbAuthsSet.addAll(loadAuthorities(user.getUsername()));

		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(dbAuthsSet);

		addCustomAuthorities(user.getUsername(), dbAuths);// 用来作为扩展

		if (dbAuths.size() == 0) {
			this.logger.debug("User '" + username + "' has no authorities and will be treated as 'not found'");

			throw new UsernameNotFoundException(this.messages.getMessage("ZhkuUserDetailsService.noAuthority",
					new Object[] { username }, "User {0} has no GrantedAuthority"));
		}

		return new ZhkuUserDetails(true, true, true, user.getEnable(), user.getUsername(), user.getPassword(),
				user.getNickname(), dbAuths);
	}

	protected void addCustomAuthorities(String username, List<GrantedAuthority> authorities) {
	}

	protected Collection<GrantedAuthority> loadAuthorities(String username) {
		List<Authorities> authorities = authoritiesMapper.selectByUsersUsername(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>(authorities.size());
		for (Authorities authority : authorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
		}
		return grantedAuthorities;
	}

}

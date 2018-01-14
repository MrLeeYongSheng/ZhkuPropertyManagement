package com.lys.zhku.security.userdetails;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 接口自带的boolean的使用由spring security来维护,若有其中一个为false,则视对象为无效,登录等会失败
 * @author MrLeeYongSheng
 *
 */
public class ZhkuUserDetails implements UserDetails {

	/**
	 * 由于实现了Serializable接口
	 */
	private static final long serialVersionUID = 1406938569686639957L;

	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private Boolean credentialsNonExpired;
	private Boolean enabled;
	
	private String username;
	private String password;
	private String nickname;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public ZhkuUserDetails(Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired,
			Boolean enabled, String username, String password, String nickname,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.authorities = authorities;
	}

	public ZhkuUserDetails() {
		this(true,true,true,null,null,null,null,null);
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

}

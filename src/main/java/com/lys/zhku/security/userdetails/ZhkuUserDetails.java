package com.lys.zhku.security.userdetails;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ZhkuUserDetails implements UserDetails {

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<SimpleGrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("user"));
		return authorities;
	}

	@Override
	public String getPassword() {
		return "b707e2640a78bc251a877f3d77210084a528ef931ce908f4ee78f3508dae7546b227baa3608e30ee";
	}

	@Override
	public String getUsername() {
		return "lys";
	}
	
	public String getGo() {
		return "go";
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}

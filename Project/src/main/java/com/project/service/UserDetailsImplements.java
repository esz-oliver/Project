package com.project.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.entity.Role;
import com.project.entity.User;

public class UserDetailsImplements implements UserDetails {

	private User user;
	
	public UserDetailsImplements(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	@Override
	public String getUsername() {
		return user.getEmail();
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
		return user.getEnabled();
	}

}
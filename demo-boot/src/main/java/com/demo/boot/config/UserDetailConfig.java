package com.demo.boot.config;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.boot.entity.User;


@SuppressWarnings("serial")
public class UserDetailConfig implements UserDetails {

	User obj;

	public UserDetailConfig() {
		super();
	}

	public UserDetailConfig(User obj) {
		super();
		this.obj = obj;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<SimpleGrantedAuthority> set=new HashSet<>();
		set.add(new SimpleGrantedAuthority(this.obj.getRoles()));
		return set;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
	
		return this.obj.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		
		return this.obj.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

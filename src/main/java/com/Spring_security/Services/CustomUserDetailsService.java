package com.Spring_security.Services;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Spring_security.Model.User;

public class CustomUserDetailsService implements UserDetails {

	
	       private User user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

	   HashSet<SimpleGrantedAuthority> st=new HashSet<>();
	   st.add(new SimpleGrantedAuthority(this.user.getRole()));
		 
		 return st;
	}

	@Override
	public String getPassword() {
		return this.user.getPasswordName();
	}

	@Override
	public String getUsername() {
		return this.user.getUserName();
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

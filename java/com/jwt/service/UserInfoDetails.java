package com.jwt.service;

import java.util.Collections;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jwt.entity.UserInfo;

public class UserInfoDetails
        implements UserDetails {

    private final UserInfo user;

    public UserInfoDetails(UserInfo user) {
        this.user = user;
    }

    @Override
    public java.util.Collection<? extends
            org.springframework.security.core.GrantedAuthority>
            getAuthorities() {

        return Collections.singleton(
            new SimpleGrantedAuthority(user.getRoles())
        );
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

	public String addUser(UserInfo user2) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
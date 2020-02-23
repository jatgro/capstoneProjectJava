package com.capstone.project.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.capstone.project.entity.Student;
import com.capstone.project.entity.User;

public class StudentDetails implements UserDetails {

	private String userName;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> authorities;
	private Student student;

	public StudentDetails(String userName) {
		this.userName = userName;
	}

	public StudentDetails(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.isActive = user.isActive();
		this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		this.student = user.getStudent();
		
	}

	public StudentDetails() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
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
		return isActive;
	}

}

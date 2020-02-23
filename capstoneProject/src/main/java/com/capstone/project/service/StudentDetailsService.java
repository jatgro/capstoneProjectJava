package com.capstone.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capstone.project.entity.User;
import com.capstone.project.repository.UserReposirtory;

@Service
public class StudentDetailsService implements UserDetailsService {
	
	@Autowired
	UserReposirtory userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
		
		return user.map(StudentDetails::new).get();
		
		
	}

}

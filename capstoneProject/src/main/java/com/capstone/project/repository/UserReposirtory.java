package com.capstone.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.project.entity.User;

// Implementation of method is provided by JPA automatically

@Repository
public interface UserReposirtory extends JpaRepository<User, Long> {
	Optional<User> findByUserName(String username);
}

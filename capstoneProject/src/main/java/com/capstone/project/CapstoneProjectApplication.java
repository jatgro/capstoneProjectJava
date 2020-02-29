package com.capstone.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.capstone.project.repository.AddressRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackages= "com.capstone.project.repository" )
public class CapstoneProjectApplication {

	@Autowired
	private AddressRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CapstoneProjectApplication.class, args);
	}

}

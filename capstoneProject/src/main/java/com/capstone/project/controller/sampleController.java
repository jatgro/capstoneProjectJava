package com.capstone.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.project.entity.Address;
import com.capstone.project.entity.Student;
import com.capstone.project.entity.User;
import com.capstone.project.models.AuthenticationRequest;
import com.capstone.project.models.AuthenticationResponse;
import com.capstone.project.models.UserResponse;
import com.capstone.project.repository.AddressRepository;
import com.capstone.project.repository.StudentRepository;
import com.capstone.project.repository.UserReposirtory;
import com.capstone.project.service.StudentDetailsService;
import com.capstone.project.util.JwtUtil;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class sampleController {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private StudentDetailsService userDetailsService;
	
	@Autowired
	private UserReposirtory userRepository;
	
	
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
			@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	@GetMapping(path="/getAllUsers")
	public List<UserResponse> allUsers(){
		List<UserResponse> userResponseList = new ArrayList<UserResponse>();
		List<User> userList =  userRepository.findAll();
		for(User user : userList) {
			UserResponse userResponse = new UserResponse();
			userResponse.setUserName(user.getUserName());
			userResponse.setPassword(user.getPassword());
			userResponse.setId(user.getId());
			userResponse.setStudentResponse(user.getStudent());
			userResponse.setRoles(user.getRoles());
			userResponseList.add(userResponse);
		}
		return userResponseList;		
	}
	
	@GetMapping(path = "/getAddressByState")
	public List<String> getAddress() {
		List<Address> addList = addressRepository.findByState("State Name");
		List<String> result = new ArrayList<String>();
		for (Address address : addList) {
			result.add(address.getPincode());
		}
		return result;
	}

	@GetMapping(path = "/getStudent/{id}")
	public String getStudentByGivenId(@PathVariable(value = "id") Long id) {
		// TODO Auto-generated constructor stub
		Optional<Student> intermediateResult = studentRepository.findById(id);
		Student student = null;
		if (intermediateResult.isPresent()) {
			student = intermediateResult.get();
		}
		return student.getName();
	}

	// Saving Operation

	@PostMapping(path = "/saveNewUser")
	public long save(@RequestBody Student student) {

//		Student student = new Student();
//		// student.setId(3);
//		student.setName("Student3");
//		student.setAge(12);

		Address address1 = new Address("Temporary", "21112", "hhggjjff", "stateNumber", student);
		Address address2 = new Address("Permanent", "z2x121q", "kakaka", "lallaala", student);
		List<Address> addressList = new ArrayList<Address>();
		addressList.add(address1);
		addressList.add(address2);
		student.setAddressList(addressList);
		return studentRepository.save(student).getId();
	}

};
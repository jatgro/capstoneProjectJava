package com.capstone.project.models;

import java.util.ArrayList;
import java.util.List;

import com.capstone.project.entity.Address;
import com.capstone.project.entity.Student;

public class UserResponse {

	private long id;
	private String userName;
	private StudentResponse studentResponse;
	private String password;
	// private boolean isActive;
	private String roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public StudentResponse getStudentResponse() {
		return studentResponse;
	}

	public void setStudentResponse(Student student) {
		List<AddressResponse> addressResponseList = new ArrayList<AddressResponse>();
		
		for(Address address : student.getAddressList()) {
			AddressResponse addRes = new AddressResponse(address.getAddress_id(), address.getType(), address.getPincode(), address.getCity(), address.getState());
			
			addressResponseList.add(addRes);
		}
		
		this.studentResponse = new StudentResponse(student.getId(), student.getName(), addressResponseList, student.getAge());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public boolean isActive() {
//		return isActive;
//	}
//
//	public void setActive(boolean isActive) {
//		this.isActive = isActive;
//	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}

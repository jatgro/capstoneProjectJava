package com.capstone.project.models;

import java.util.List;

public class StudentResponse {

	private long id;
	private String name;
	private List<AddressResponse> addressResponseList;
	private int age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public List<AddressResponse> getAddressResponseList() {
		return addressResponseList;
	}

	public void setAddressResponseList(List<AddressResponse> addressResponseList) {
		this.addressResponseList = addressResponseList;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public StudentResponse(long id, String name, List<AddressResponse> addressResponseList, int age) {
		super();
		this.id = id;
		this.name = name;
		this.addressResponseList = addressResponseList;
		this.age = age;
	}

	
	
	

}

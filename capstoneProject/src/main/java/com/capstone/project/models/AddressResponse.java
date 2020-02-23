package com.capstone.project.models;

public class AddressResponse {

	private long addressId;
	private String type;
	private String pincode;
	private String city;
	private String state;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public AddressResponse(long addressId, String type, String pincode, String city, String state) {
		super();
		this.addressId = addressId;
		this.type = type;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
	}
	
	

}

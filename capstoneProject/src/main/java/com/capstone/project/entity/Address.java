package com.capstone.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Address_id")
	private long address_id;

	@Column(name = "Address_Type")
	private String type;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "student_id", nullable = false)
	private Student student;

	public long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Address() {

	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", pincode=" + pincode + ", city=" + city + ", state=" + state
				+ ", student=" + student + "]";
	}

	public Address(String type, String pincode, String city, String state, Student student) {
		super();
		this.type = type;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.student = student;
	}

}

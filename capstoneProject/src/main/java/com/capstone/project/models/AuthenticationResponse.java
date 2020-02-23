package com.capstone.project.models;

public class AuthenticationResponse {
	// Output Structure for the authenticate method
	private final String jwt;

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}

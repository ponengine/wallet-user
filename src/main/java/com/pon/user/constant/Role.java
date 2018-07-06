package com.pon.user.constant;

public enum Role {
	
	USER("U"),
	ADMIN("A"),
	BLACKLIST("B");
	
	private String role;

	public String getRole() {
		return role;
	}

	private Role(String role) {
		this.role = role;
	}
	
	
}

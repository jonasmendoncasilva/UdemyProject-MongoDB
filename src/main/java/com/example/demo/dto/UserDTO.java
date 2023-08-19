package com.example.demo.dto;

import com.example.demo.entities.User;

public record UserDTO(
		String id, 
		String name, 
		String email) {

	public UserDTO(User user) {
		this(user.getId(),user.getName(),user.getEmail());
	}
	
	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public String email() {
		return email;
	}
}

package com.example.demo.dto;

import com.example.demo.entities.User;

public record AuthorDTO(String id, String name) {

	public AuthorDTO(User user) {
		this(user.getId(), user.getName());
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}
}

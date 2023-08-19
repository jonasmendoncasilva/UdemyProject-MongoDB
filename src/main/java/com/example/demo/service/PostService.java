package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}

	public Post findById(String id) {
		Optional<Post> u = repository.findById(id);
		return u.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}

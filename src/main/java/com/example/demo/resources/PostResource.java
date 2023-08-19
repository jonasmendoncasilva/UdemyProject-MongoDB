package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Post;
import com.example.demo.service.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		List<Post> list = service.findAll();  
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		  Post obj = service.findById(id);
		  return ResponseEntity.ok().body(obj);
	}
}
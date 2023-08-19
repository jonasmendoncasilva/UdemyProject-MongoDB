package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> u = repository.findById(id);
		return u.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repository.insert(obj);	
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User newObj) {
	    Optional<User> obj1 = repository.findById(newObj.getId());
	    User obj = obj1.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	    return repository.save(updateData(obj, newObj));
	}
	
	public User updateData(User obj, User newObj) {
		obj.setName(newObj.getName());
		obj.setEmail(newObj.getEmail());
		return obj;
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.id(),userDTO.name(),userDTO.email());
	}
}

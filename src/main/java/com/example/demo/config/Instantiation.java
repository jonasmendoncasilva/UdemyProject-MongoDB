package com.example.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.entities.Comment;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		AuthorDTO alt1 = new AuthorDTO(maria);
		AuthorDTO alt2 = new AuthorDTO(maria);
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!!",alt1);
		Post post2 = new Post(null,sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!",alt2);
		
		Comment c1 = new Comment("Boa viagem mano",sdf.parse("21/03/2018"), new AuthorDTO(alex));
		Comment c2 = new Comment("Aproveite",sdf.parse("22/03/2018"), new AuthorDTO(bob));
		Comment c3 = new Comment("Boa viagem mano",sdf.parse("23/03/2018"), new AuthorDTO(alex));
	
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
	}
}

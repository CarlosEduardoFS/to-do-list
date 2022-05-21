package com.task.resources;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.task.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User u1 = new User(1L,"Eduardo");
		User u2 = new User(1L,"Maria");
		User u3 = new User(1L,"Gustavo");
		List<User> list = new LinkedList<>(); 
		list.addAll(Arrays.asList(u1,u2,u3));
		return ResponseEntity.ok().body(list);
	}	

}

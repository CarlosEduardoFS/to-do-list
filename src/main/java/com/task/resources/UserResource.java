package com.task.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.task.domain.User;
import com.task.service.UserService;
import com.task.util.Util;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = userService.findById(id);
		obj.setTask(Util.activeTasks(obj.getTasks()));
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> insert(@RequestBody User user){
		user = userService.insert(user);
		return ResponseEntity.ok().body(user);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		userService.deletebyId(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id){
		user.setId(id);
		user = userService.udpate(user);
		return ResponseEntity.ok().body(user);
	}

}

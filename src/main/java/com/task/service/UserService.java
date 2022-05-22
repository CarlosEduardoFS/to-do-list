package com.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.domain.User;
import com.task.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public User insert(User user) {
		userRepository.save(user);
		return user;
	}
	
	public void deletebyId(Long id) {
		userRepository.deleteById(id);
	}
	
	public User udpate(User user) {
		user = userRepository.save(user);
		return user;
	}
	
}

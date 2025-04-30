package com.solix.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solix.demo.model.User;

@Service
public class UserService {

	@Autowired
	Map<Integer, User> usersMap;
	
	public User getUserById(int id) {
		return usersMap.get(id);
	}
	
	public List<User> getUsersByRole(String role){
		List<User> users = usersMap.entrySet()
						   .stream()
						   .filter(entry -> entry.getValue().getRole().equalsIgnoreCase(role))
						   .map(entry -> entry.getValue())
						   .toList();
		
		return users;
	}
}

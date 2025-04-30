package com.solix.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solix.demo.exception.RoleNotFoundException;
import com.solix.demo.exception.UserNotFoundException;
import com.solix.demo.model.User;
import com.solix.demo.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserRESTController {

	@Autowired
	UserService userService;
	
	@GetMapping(value = "/getUserDetailsById/{id}", produces = "application/json")
	public ResponseEntity<User> findUserById(@PathVariable int id){
		User user = userService.getUserById(id);
		
		if(user == null) {
			throw new UserNotFoundException("User with id : " + id + " doesn't exist");
			// The above message will be displayed in CONSOLE , but not in POSTMAN...
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK); // body and status code, but headers is not included...
	}
	
	@GetMapping(value = "/role/{rolename}", produces = "application/json")
	public ResponseEntity<List<User>> findUsersByRole(@PathVariable("rolename") String role){
		List<User> users = userService.getUsersByRole(role);
		
		if(users.isEmpty()) {
			throw new RoleNotFoundException("No users found with role : " + role);
			// The above message will be displayed in CONSOLE , but not in POSTMAN...
		}
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	
	
}

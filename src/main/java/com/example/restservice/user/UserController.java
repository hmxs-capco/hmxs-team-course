package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

	private final static String USERS_BASE_ENDPOINT = "/users";

//	@Autowired
//	private UserService userService;

	@Autowired
	private UserRepository userRepo;

	@GetMapping("/users")
	public ResponseEntity<List<User>> users() {
		return new ResponseEntity<List<User>>(userRepo.findAll(), HttpStatus.OK);
	}

}

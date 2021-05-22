package com.example.restservice.user;

import com.example.restservice.common.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	private static final String USERS_BASE_ENDPOINT = "/users";
	private static final String USERS_ID = "/{userId}";

	@Autowired
	private UserRepository userRepo;

	@GetMapping(USERS_BASE_ENDPOINT)
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = USERS_BASE_ENDPOINT + USERS_ID)
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		User user = userRepo.findUserById(userId);
		if (user == null) {
			LOGGER.error("UserController: User not found");
			throw new NotFoundException();
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping(value = USERS_BASE_ENDPOINT)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
	}

}

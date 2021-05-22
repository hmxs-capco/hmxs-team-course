package com.example.restservice.greeting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	public static final String DEFAULT_GREETING = "User";
	private static final String GREETING_BASE_ENDPOINT = "/hello";

	@GetMapping(GREETING_BASE_ENDPOINT)
	public ResponseEntity<Greeting> sayHello(
			@RequestParam(value = "name", defaultValue = DEFAULT_GREETING) String name) {
		return new ResponseEntity<>(new Greeting(GreetingFormatter.format(name)), HttpStatus.OK);
	}
}

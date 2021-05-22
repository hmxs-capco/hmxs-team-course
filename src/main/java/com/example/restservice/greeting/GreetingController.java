package com.example.restservice.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String HELLO_BASE_URL = "/hello";
	private static final String HELLO_TEMPLATE = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	@GetMapping(HELLO_BASE_URL)
	public Greeting hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(HELLO_TEMPLATE, name));
	}
}

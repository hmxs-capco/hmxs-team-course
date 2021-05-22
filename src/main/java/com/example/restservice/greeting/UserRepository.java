package com.example.restservice.greeting;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

	public User findByFirstname(String firstname);
	public List<User> findByLastname(String lastname);

}

package com.example.restservice.greeting;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingControllerTest {

    private GreetingController subject = new GreetingController();
    private String fakeName;

    @Test
    public void greetingWithFakeName_greetingIsTheExpected() {
        fakeName = "Jackson";
        ResponseEntity<Greeting> greeting = subject.sayHello(fakeName);
        assertEquals(Objects.requireNonNull(greeting.getBody()).getContent(), getExpectedGreeting());
    }

    private String getExpectedGreeting() {
        return GreetingFormatter.format(fakeName);
    }

}

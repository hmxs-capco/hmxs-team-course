package com.example.restservice.greeting;

import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.assertEquals;

@ContextConfiguration(classes = { GreetingConfig.class })
public class GreetingIntegrationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private GreetingController controller;
    private String fakeName;

    @Test
    public void greetingWithFakeName_greetingIsTheExpected() {
        // given
        fakeName = "Jackson";

        // when
        ResponseEntity<Greeting> greeting = controller.sayHello(fakeName);

        // then
        assertEquals(greeting.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(Objects.requireNonNull(greeting.getBody()).getContent(),
                GreetingFormatter.format(fakeName));
    }

}

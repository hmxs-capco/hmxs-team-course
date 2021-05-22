package com.example.restservice.greeting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingControllerTest {

    private GreetingController subject = new GreetingController();
    private String fakeName;

    @Test
    public void nameIsEmpty_greetingIsTheExpected() {
        fakeName = "";
        Greeting greeting = subject.sayHello(fakeName);
        assertEquals(greeting.getContent(), getExpectedGreeting());
    }

    @Test
    public void nameIsNotEmpty_greetingIsTheExpected() {
        fakeName = "Jackson";
        Greeting greeting = subject.sayHello(fakeName);
        assertEquals(greeting.getContent(), getExpectedGreeting());
    }

    private String getExpectedGreeting() {
        return GreetingFormatter.format(fakeName);
    }

}

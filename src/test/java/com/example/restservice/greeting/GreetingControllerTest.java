package com.example.restservice.greeting;

import org.testng.annotations.Test;
import org.springframework.http.ResponseEntity;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingControllerTest {

    private GreetingController subject = new GreetingController();
    private String fakeName;

    @Test
    public void greetingWithFakeName_greetingIsTheExpected() {
        // given
        fakeName = "Jackson";

        // when
        ResponseEntity<Greeting> greeting = subject.sayHello(fakeName);

        // then
        assertEquals(Objects.requireNonNull(greeting.getBody()).getContent(), getExpectedGreeting());
    }

    private String getExpectedGreeting() {
        return GreetingFormatter.format(fakeName);
    }

}

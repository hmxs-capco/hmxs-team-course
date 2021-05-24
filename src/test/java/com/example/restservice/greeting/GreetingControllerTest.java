package com.example.restservice.greeting;

import org.springframework.http.HttpStatus;
import org.testng.Assert;
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
        Assert.assertEquals(greeting.getStatusCode(), HttpStatus.OK);
        assertEquals(Objects.requireNonNull(greeting.getBody()).getContent(),
                GreetingFormatter.format(fakeName));
    }

}

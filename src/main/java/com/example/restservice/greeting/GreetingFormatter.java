package com.example.restservice.greeting;

public class GreetingFormatter {

    public static final String GREETING_TEMPLATE = "Hello %s";

    public static String format(String name) {
        return String.format(GREETING_TEMPLATE, name);
    }
}

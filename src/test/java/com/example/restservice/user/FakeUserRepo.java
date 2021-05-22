package com.example.restservice.user;

import java.util.ArrayList;
import java.util.List;

public class FakeUserRepo {

    public static List<User> getFakeUsers() {
        List<User> users = new ArrayList<>();
        users.add(createFakeUser("1", "James", "Jackson"));
        users.add(createFakeUser("2", "Nick", "Holmes"));
        return users;
    }

    public static User createFakeUser(String id, String first, String last) {
        User user = new User(first, last);
        user.setId(id);
        return user;
    }

    public static User getFakeUser() {
        User user = new User("Jack", "Mathew");
        user.setId("1");
        return user;
    }

}

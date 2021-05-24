package com.example.restservice.user;

import java.util.ArrayList;
import java.util.List;

public class UserTestUtil {

    public static List<User> getSavedUsers() {
        List<User> users = new ArrayList<>();
        users.add(createSavedUser("1", "James", "Jackson"));
        users.add(createSavedUser("2", "Nick", "Holmes"));
        return users;
    }

    public static User getSavedUser() {
        return createSavedUser("10", "James", "Jackson");
    }

    public static User createSavedUser(String id, String first, String last) {
        User user = new User(first, last);
        user.setId(id);
        return user;
    }

}

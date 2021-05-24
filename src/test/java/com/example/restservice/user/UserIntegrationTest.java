package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;

@ContextConfiguration(classes = {UserConfig.class})
public class UserIntegrationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserController controller;

    @Test
    public void postUser_userIsSaved() {
        // given
        User postedUser = new User();
        postedUser.setFirstName("John");
        postedUser.setLastName("Maxwell");

        // when
        postUser(postedUser);
        List<User> users = getUsers();

        // then
        assertEquals(users.size(), 1);
        User savedUser = users.get(0);
        assertEquals(savedUser.getFirstName(), postedUser.getFirstName());
        assertEquals(savedUser.getLastName(), postedUser.getLastName());

        // when
        deleteUser(savedUser.getId());

        // then
        List<User> updatedUsers = getUsers();
        assertEquals(updatedUsers.size(), 0);
    }

    private List<User> getUsers() {
        ResponseEntity<List<User>> response = controller.getUsers();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        return response.getBody();
    }

    private User postUser(User user) {
        ResponseEntity<User> response = controller.addUser(user);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        return response.getBody();
    }

    private void deleteUser(String id) {
        ResponseEntity<User> response = controller.deleteUser(id);
        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }

}

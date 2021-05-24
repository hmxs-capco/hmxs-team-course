package com.example.restservice.user;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Objects;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertNotNull;

public class UserControllerTest {

    @BeforeMethod
    public void doBefore() {
        MockitoAnnotations.openMocks(this);
    }

    @InjectMocks
    private UserController subject = new UserController();

    @Mock
    private UserRepository mockUserRepo;

    @Test
    public void callingGetUsers_returnsExpectedUsers() {
        // given
        List<User> fakeUsers = UserTestUtil.getSavedUsers();
        when(mockUserRepo.findAll()).thenReturn(fakeUsers);

        // when
        ResponseEntity<List<User>> response = subject.getUsers();

        // then
        verify(mockUserRepo).findAll();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(Objects.requireNonNull(response.getBody()).size(), fakeUsers.size());

        for (User user : response.getBody()) {
            verifyUser(user);
        }
    }

    @Test
    public void callingAddUser_returnsExpectedResponseCode() {
        // given
        User fakeUser = UserTestUtil.getSavedUser();
        when(mockUserRepo.save(fakeUser)).thenReturn(fakeUser);

        // when
        ResponseEntity<User> response = subject.addUser(fakeUser);

        // then
        verify(mockUserRepo).save(fakeUser);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    private static void verifyUser(User user) {
        assertNotNull(user);
        assertTrue(isNotNullOrEmpty(user.getId()));
        assertTrue(isNotNullOrEmpty(user.getFirstName()));
        assertTrue(isNotNullOrEmpty(user.getLastName()));
    }

    private static boolean isNotNullOrEmpty(String input) {
        return input != null && input.trim().length() > 0;
    }


}

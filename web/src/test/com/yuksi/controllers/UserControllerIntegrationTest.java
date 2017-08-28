package com.yuksi.controllers;

import com.yuksi.controllers.security.Application;
import com.yuksi.entities.User;
import com.yuksi.exceptions.UsernameAlreadyInUseException;
import com.yuksi.services.IUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by Yuksi on 01.08.2017.
 *
 * this time it is integrational test
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserControllerIntegrationTest {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private User user;

    @Before
    public void init() {
        user.setLogin("testuser");
        user.setName("Testuser");
        user.setSurname("TestUser");
        user.setEmail("testuser@ukr.net");
        user.setPswd("testuser");
        user.setRegDate(LocalDateTime.now());
        try {
            iUserService.createNew("testuser", "Testuser", "TestUser", "testuser@ukr.net", "testuser");
        } catch (UsernameAlreadyInUseException e) {
            e.printStackTrace();
        }
    }

    @After
    public void delete() {
        iUserService.deleteByUser(user.getId(),user.getPswd());
    }

    @Test
    public void findByLogin() throws Exception {
        User newUser = iUserService.findByLogin(user.getLogin());
        assertEquals(user, newUser);
        user.setId(newUser.getId());
    }

    @Test
    public void findByName() throws Exception {
        user.setLogin("admin");
        user.setName("Admin");
        user.setSurname("Administrator");
        user.setEmail("admin@ukr.net");
        user.setPswd("admin");
        User[] users = {user};

        User[] findUsers = new User[1];
        findUsers = iUserService.findByName(user.getName()).toArray(findUsers);

        assertArrayEquals(users, findUsers);
    }

}
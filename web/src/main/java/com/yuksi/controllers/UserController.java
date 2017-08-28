package com.yuksi.controllers;

import com.yuksi.entities.User;
import com.yuksi.exceptions.UsernameAlreadyInUseException;
import com.yuksi.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Yuksi on 27.07.2017.
 */

@RestController
@RequestMapping(value= "/users")
public class UserController {

    @Autowired
    IUserService iUserService;

    /* first test method */
    @RequestMapping("/hi")
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    public User userInfo(@PathVariable long id) {
        return iUserService.findById(id);
    }

    @RequestMapping(value= "/search/login", method = RequestMethod.GET)
    public User userByLogin(@RequestParam String login) {
        return iUserService.findByLogin(login);
    }

    @RequestMapping(value= "/search/name", method = RequestMethod.GET)
    public List<User> userByName(@RequestParam String name) {
        return iUserService.findByName(name);
    }

    @RequestMapping(value= "/all", method = RequestMethod.GET)
    public List<User> usersAll() {
        return iUserService.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public User createNewUser(@RequestParam String login, String name,
                              String surname, String email, String password) {
        User user = null;
        try {
            user = iUserService.createNew(login, name, surname, email, password);
        } catch (UsernameAlreadyInUseException e) {
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User changingUserInfo(@PathVariable long id, @RequestParam String name,
                                 String surname, String email, String password) {
        return iUserService.changingInfo(id, name, surname, email, password);
    }

    @RequestMapping(value = "/changerole/{id}", method = RequestMethod.PUT)
    public User changingRole(@PathVariable long id, @RequestParam String role) {
        return iUserService.changingRole(id, role);
    }

    @RequestMapping(value = "/changestatus/{id}", method = RequestMethod.PUT)
    public User changingStatus(@PathVariable long id, @RequestParam String status) {
        return iUserService.changingStatus(id, status);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteByUser(@PathVariable long id, @RequestParam String password) {
        iUserService.deleteByUser(id, password);
    }
}
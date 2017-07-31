package com.yuksi.controllers;

import com.yuksi.dto.UserDtoFullInfo;
import com.yuksi.entities.User;
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

    @RequestMapping(value= "/{login}", method = RequestMethod.GET)
    public User userByLogin(@PathVariable String login) {
        return iUserService.findByLogin(login);
    }

    @RequestMapping(value= "/search/{name}", method = RequestMethod.GET)
    public List<User> userByName(@PathVariable String name) {
        return iUserService.findByName(name);
    }

    @RequestMapping(value= "/all", method = RequestMethod.GET)
    public List<User> usersAll() {
        return iUserService.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public User createNewUser(@RequestParam String login, String name,
                              String surname, String email, String password) {
        return iUserService.createNew(login, name, surname, email, password);
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.PUT)
    public User changingUserInfo(@RequestParam String login, String name,
                              String surname, String email, String password) {
        return iUserService.changingInfo(login, name, surname, email, password);
    }

    @RequestMapping(value = "/changerole/{login}", method = RequestMethod.PUT)
    public User changingRole(@PathVariable String login, @RequestParam String role) {
        return iUserService.changingRole(login, role);
    }

    @RequestMapping(value = "/changestatus/{login}", method = RequestMethod.PUT)
    public User changingStatus(@PathVariable String login, @RequestParam String status) {
        return iUserService.changingStatus(login, status);
    }
}

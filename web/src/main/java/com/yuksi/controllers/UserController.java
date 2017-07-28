package com.yuksi.controllers;

import com.yuksi.dto.UserDtoFullInfo;
import com.yuksi.entities.User;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yuksi on 27.07.2017.
 */

@RestController
public class UserController {

    @RequestMapping("/hi")
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value= "/users/{login}", method = RequestMethod.GET)
    public User userByLogin(@PathVariable String login) {
        User user = new User();
        user.setId(1);
        user.setLogin(login);
        user.setName("Admin");
        return user;
    }
}

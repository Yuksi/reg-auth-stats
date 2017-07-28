package com.yuksi.controllers;

import com.yuksi.dto.UserDtoFullInfo;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Yuksi on 27.07.2017.
 */

@RestController
public class UserController {

    @RequestMapping("/users/hi")
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value= "/users/{login}", method = RequestMethod.GET)
    public UserDtoFullInfo userFullInfoByLogin(@PathVariable String login) {
        UserDtoFullInfo user = new UserDtoFullInfo();
        user.setId(1);
        user.setLogin(login);
        user.setName("Admin");
        return user;
    }
}

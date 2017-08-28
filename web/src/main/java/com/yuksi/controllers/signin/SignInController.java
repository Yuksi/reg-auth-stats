package com.yuksi.controllers.signin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yuksi on 28.08.2017.
 */

@RestController
public class SignInController {

    @RequestMapping(value="/signin", method= RequestMethod.GET)
    public void signin() {
    }
}

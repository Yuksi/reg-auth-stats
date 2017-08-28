package com.yuksi.controllers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.security.Principal;


/**
 * Created by Yuksi on 08.08.2017.
 */

@RestController
public class SignController{

    private static final Logger LOGGER = LogManager.getLogger(SignController.class.getName());

    @RequestMapping({ "/user", "/me" })
    public Principal user(Principal principal) {
        LOGGER.info("principal.getName = " + principal.getName());
        LOGGER.info("principal = " + principal);
        return principal;
    }


    /*
    @RequestMapping({ "/user", "/me" })
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());

        LOGGER.info("principal.getName = " + principal.getName());
        LOGGER.info("principal = " + principal);

        return map;
    }
    */

}

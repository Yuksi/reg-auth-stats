package com.yuksi.controllers.signin;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Yuksi on 28.08.2017.
 */
public class SignInUtils {

    public static void signin(String userId) {
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userId, null, null));
    }
}

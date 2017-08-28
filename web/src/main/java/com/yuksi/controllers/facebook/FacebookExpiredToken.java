package com.yuksi.controllers.facebook;

/**
 * Created by Yuksi on 28.08.2017.
 */
import org.springframework.social.ExpiredAuthorizationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FacebookExpiredToken {

    @RequestMapping("/facebook/expired")
    public void simulateExpiredToken() {
        throw new ExpiredAuthorizationException("facebook");
    }

}

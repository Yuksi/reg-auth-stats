package com.yuksi.controllers.facebook;

/**
 * Created by Yuksi on 28.08.2017.
 */
import javax.inject.Inject;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FacebookFeedController {

    private final Facebook facebook;

    @Inject
    public FacebookFeedController(Facebook facebook) {
        this.facebook = facebook;
    }

    @RequestMapping(value="/facebook/feed", method=RequestMethod.GET)
    public String showFeed(Model model) {
        model.addAttribute("feed", facebook.feedOperations().getFeed());
        return "facebook/feed";
    }

    @RequestMapping(value="/facebook/feed", method=RequestMethod.POST)
    public String postUpdate(String message) {
        facebook.feedOperations().updateStatus(message);
        return "redirect:/facebook/feed";
    }

}
package com.yuksi.controllers;

/**
 * Created by Yuksi on 28.08.2017.
 */
import java.security.Principal;

import javax.inject.Inject;
import javax.inject.Provider;

import com.yuksi.services.UserService;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    private final Provider<ConnectionRepository> connectionRepositoryProvider;

    private final UserService userService;

    @Inject
    public HomeController(Provider<ConnectionRepository> connectionRepositoryProvider, UserService userService) {
        this.connectionRepositoryProvider = connectionRepositoryProvider;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home(Principal currentUser, Model model) {
        model.addAttribute("connectionsToProviders", getConnectionRepository().findAllConnections());
        if (currentUser != null) {
            model.addAttribute(userService.findByLogin(currentUser.getName()));
        }
        return "home";
    }

    private ConnectionRepository getConnectionRepository() {
        return connectionRepositoryProvider.get();
    }
}

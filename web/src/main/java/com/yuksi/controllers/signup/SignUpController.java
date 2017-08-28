package com.yuksi.controllers.signup;

/**
 * Created by Yuksi on 28.08.2017.
 */
import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.yuksi.entities.User;
import com.yuksi.services.UserService;
import com.yuksi.exceptions.UsernameAlreadyInUseException;
import com.yuksi.message.Message;
import com.yuksi.message.MessageType;
import com.yuksi.controllers.signin.SignInUtils;

@Controller
public class SignUpController {

    private final UserService userService;
    private final ProviderSignInUtils providerSignInUtils;

    @Inject
    public SignUpController(UserService userService,
                            ConnectionFactoryLocator connectionFactoryLocator,
                            UsersConnectionRepository connectionRepository) {
        this.userService = userService;
        this.providerSignInUtils = new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
    }

    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public SignUpForm signupForm(WebRequest request) {
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
        if (connection != null) {
            request.setAttribute("message", new Message(MessageType.INFO, "Your " + StringUtils.capitalize(connection.getKey().getProviderId()) + " account is not associated with a Spring Social Showcase account. If you're new, please sign up."), WebRequest.SCOPE_REQUEST);
            return SignUpForm.fromProviderUser(connection.fetchUserProfile());
        } else {
            return new SignUpForm();
        }
    }

    @RequestMapping(value="/signup", method=RequestMethod.POST)
    public String signup(@Valid SignUpForm form, BindingResult formBinding, WebRequest request) {
        if (formBinding.hasErrors()) {
            return null;
        }
        User user = createAccount(form, formBinding);
        if (user != null) {
            SignInUtils.signin(user.getLogin());
            providerSignInUtils.doPostSignUp(user.getLogin(), request);
            return "redirect:/";
        }
        return null;
    }

    private User createAccount(SignUpForm form, BindingResult formBinding) {
        try {
            User user = userService.createNew(form.getUsername(), form.getFirstName(), form.getLastName(), null, form.getPassword());
            return user;
        } catch (UsernameAlreadyInUseException e) {
            formBinding.rejectValue("username", "user.duplicateUsername", "already in use");
            return null;
        }
    }

}

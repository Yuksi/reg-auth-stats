package com.yuksi.controllers.signup;

/**
 * Created by Yuksi on 28.08.2017.
 */
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.social.connect.UserProfile;

public class SignUpForm {

    @NotEmpty
    private String username;

    @Size(min = 6, message = "must be at least 6 characters")
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static SignUpForm fromProviderUser(UserProfile providerUser) {
        SignUpForm form = new SignUpForm();
        form.setFirstName(providerUser.getFirstName());
        form.setLastName(providerUser.getLastName());
        form.setUsername(providerUser.getUsername());
        return form;
    }
}

package com.yuksi.exceptions;

/**
 * Created by Yuksi on 28.08.2017.
 */
public class UsernameAlreadyInUseException extends Exception {
    public UsernameAlreadyInUseException(String username) {
        super("The username '" + username + "' is already in use.");
    }
}

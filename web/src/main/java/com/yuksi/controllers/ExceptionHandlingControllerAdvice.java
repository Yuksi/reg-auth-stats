package com.yuksi.controllers;

/**
 * Created by Yuksi on 28.08.2017.
 */
import org.springframework.social.RateLimitExceededException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

    @ExceptionHandler(RateLimitExceededException.class)
    public String rateLimitExceeded(RateLimitExceededException e, Model model) {
        model.addAttribute("providerId", e.getProviderId());
        return "ratelimit";
    }

}
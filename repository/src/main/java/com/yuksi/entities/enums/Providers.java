package com.yuksi.entities.enums;

/**
 * Created by Yuksi on 19.04.2017.
 */
public enum Providers {
    FACEBOOK(0),
    GOOGLE(1);

    int provider;

    Providers (int provider) {
        this.provider = provider;
    }
}

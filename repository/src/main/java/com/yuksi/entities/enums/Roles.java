package com.yuksi.entities.enums;

/**
 * Created by Yuksi on 19.04.2017.
 */
public enum Roles {
    USER (0),
    ADMIN (1), //смотрит статистику, меняет статус юзера
    SUPER (2); //возможности админ + меняет роль юзера

    int role;

    Roles (int role) {
        this.role = role;
    }
}

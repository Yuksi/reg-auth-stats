package com.yuksi.entities.enums;

/**
 * Created by Yuksi on 19.04.2017.
 */
public enum UserStatuses {
    ENABLED (0),
    BLOCKED (1);

    private int status;

    UserStatuses(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}

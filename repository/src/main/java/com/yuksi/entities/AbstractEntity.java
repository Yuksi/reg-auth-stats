package com.yuksi.entities;

/**
 * Created by Yuksi on 19.04.2017.
 */
public abstract class AbstractEntity {
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

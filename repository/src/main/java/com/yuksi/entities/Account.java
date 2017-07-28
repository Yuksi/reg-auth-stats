package com.yuksi.entities;

import com.yuksi.entities.enums.Providers;


/**
 * Created by Yuksi on 18.04.2017.
 *
 * when new Account created - creation User with data from Account
 */
public class Account {

    long id;
    long userId;
    Providers networkName;
    String socialUserId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Providers getNetworkName() {
        return networkName;
    }

    public void setNetworkName(Providers networkName) {
        this.networkName = networkName;
    }

    public String getSocialUserId() {
        return socialUserId;
    }

    public void setSocialUserId(String socialUserId) {
        this.socialUserId = socialUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (networkName != account.networkName) return false;
        return socialUserId != null ? socialUserId.equals(account.socialUserId) : account.socialUserId == null;

    }

    @Override
    public int hashCode() {
        int result = networkName != null ? networkName.hashCode() : 0;
        result = 31 * result + (socialUserId != null ? socialUserId.hashCode() : 0);
        return result;
    }
}

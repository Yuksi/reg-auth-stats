package com.yuksi.entities;

import com.yuksi.entities.enums.Providers;

import javax.persistence.*;


/**
 * Created by Yuksi on 18.04.2017.
 *
 * when new Account created - creation User with data from Account
 */

@Entity
@Table(name="SOCIAL_ACCOUNTS")
public class Account {

    @Id
    @Column(name="id_acc")
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name="user_id")
    long userId;

    @Column(name="network")
    int networkName;

    @Column(name="social_id")
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

    public int getNetworkName() {
        return networkName;
    }

    public void setNetworkName(int networkName) {
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

        if (userId != account.userId) return false;
        if (networkName != account.networkName) return false;
        return socialUserId != null ? socialUserId.equals(account.socialUserId) : account.socialUserId == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + networkName;
        result = 31 * result + (socialUserId != null ? socialUserId.hashCode() : 0);
        return result;
    }
}

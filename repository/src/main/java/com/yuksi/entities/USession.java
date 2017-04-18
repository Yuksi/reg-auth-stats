package com.yuksi.entities;

import java.time.LocalDateTime;

/**
 * Created by Yuksi on 18.04.2017.
 */
public class USession extends AbstractEntity{
    long userId;
    LocalDateTime login_date = LocalDateTime.now();
    LocalDateTime logout_date;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDateTime getLogin_date() {
        return login_date;
    }

    public void setLogin_date(LocalDateTime login_date) {
        this.login_date = login_date;
    }

    public LocalDateTime getLogout_date() {
        return logout_date;
    }

    public void setLogout_date(LocalDateTime logout_date) {
        this.logout_date = logout_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        USession uSession = (USession) o;

        if (id != uSession.id) return false;
        if (userId != uSession.userId) return false;
        if (login_date != null ? !login_date.equals(uSession.login_date) : uSession.login_date != null) return false;
        return logout_date != null ? logout_date.equals(uSession.logout_date) : uSession.logout_date == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (login_date != null ? login_date.hashCode() : 0);
        result = 31 * result + (logout_date != null ? logout_date.hashCode() : 0);
        return result;
    }
}

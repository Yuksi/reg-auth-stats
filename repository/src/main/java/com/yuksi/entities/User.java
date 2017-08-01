package com.yuksi.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Yuksi on 18.04.2017.
 */

@Entity
@Table(name="USERS")
public class User {
    /** used for registration */
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String login;
    String name;
    String surname;
    String email;

    @Column(name="reg_date")
    LocalDateTime regDate;

    @Column(name="change_date")
    LocalDateTime changeDate;
    int role;
    int status;
    /** used for registration */
    String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPswd() {
        return password;
    }

    public void setPswd(String pswd) {
        this.password = pswd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return login != null ? login.equals(user.login) : user.login == null;

    }

    @Override
    public int hashCode() {
        return login != null ? login.hashCode() : 0;
    }
}

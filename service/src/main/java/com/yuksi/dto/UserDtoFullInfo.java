package com.yuksi.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuksi on 27.07.2017.
 */
public class UserDtoFullInfo {

    long id;
    String login;
    String name;
    String surname;
    String email;
    LocalDateTime regDate;
    LocalDateTime changeDate;
    String role;
    String status;
    List<String> accounts = new ArrayList<>();

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "UserDtoFullInfo{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", regDate=" + regDate +
                ", changeDate=" + changeDate +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}

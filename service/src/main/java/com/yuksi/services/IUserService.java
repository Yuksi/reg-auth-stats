package com.yuksi.services;

import com.yuksi.entities.User;
import java.util.List;


/**
 * Created by Yuksi on 31.07.2017.
 */
public interface IUserService {

    User findByLogin(String login);

    List<User> findByName(String name);

    List<User> findAll();

    User createNew(String login, String name, String surname, String email, String password);

    User changingInfo(String login, String name, String surname, String email, String password);

    User changingStatus(String login, String status);

    User changingRole(String login, String role);
}

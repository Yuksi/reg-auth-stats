package com.yuksi.services;

import com.yuksi.entities.User;
import java.util.List;


/**
 * Created by Yuksi on 31.07.2017.
 */
public interface IUserService {

    User findById(long id);

    User findByLogin(String login);

    List<User> findByName(String name);

    List<User> findAll();

    User createNew(String login, String name, String surname, String email, String password);

    User changingInfo(long id, String name, String surname, String email, String password);

    User changingStatus(long id, String status);

    User changingRole(long id, String role);

    boolean deleteByUser(long id, String password);
}

package com.yuksi.services;

import com.yuksi.entities.enums.Roles;
import com.yuksi.entities.enums.UserStatuses;
import com.yuksi.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuksi.entities.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Yuksi on 31.07.2017.
 */

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    public User findByLogin(String login) {
        return iUserRepository.findByLogin(login);
    }

    @Override
    public List<User> findByName(String name) {
        return iUserRepository.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User createNew(String login, String name, String surname, String email, String password) {
        if (iUserRepository.findByLogin(login) != null) {
            return null;
        }
        User user = new User();
        user.setLogin(login);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPswd(password);
        user.setRole(Roles.USER.getRole());
        user.setStatus(UserStatuses.ENABLED.getStatus());
        user.setRegDate(LocalDateTime.now());
        iUserRepository.save(user);

        return user;
    }

    @Override
    public User changingInfo(String login, String name, String surname, String email, String password) {
        User user = iUserRepository.findByLogin(login);
        if (user == null) {
            return null;
        }
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPswd(password);
        user.setChangeDate(LocalDateTime.now());
        iUserRepository.save(user);
        return user;
    }

    @Override
    public User changingStatus(String login, String status) {
        User user = iUserRepository.findByLogin(login);
        if (user == null) {
            return null;
        }
        user.setStatus(UserStatuses.valueOf(status).getStatus());
        user.setChangeDate(LocalDateTime.now());
        iUserRepository.save(user);
        return user;
    }

    @Override
    public User changingRole(String login, String role) {
        User user = iUserRepository.findByLogin(login);
        if (user == null) {
            return null;
        }
        user.setRole(Roles.valueOf(role).getRole());
        user.setChangeDate(LocalDateTime.now());
        iUserRepository.save(user);
        return user;
    }

}

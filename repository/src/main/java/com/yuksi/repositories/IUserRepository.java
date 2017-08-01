package com.yuksi.repositories;

import com.yuksi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


/**
 * Created by Yuksi on 28.07.2017.
 */
@RepositoryRestResource
public interface IUserRepository extends JpaRepository<User, Long> {

    User findByLogin(@Param("login") String login);

    List<User> findByName(@Param("name") String name);


}

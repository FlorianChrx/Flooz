package com.owle.OwleAPI.repositories;

import com.owle.OwleAPI.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, String> {
    @Modifying
    @Transactional
    @Query("update User u set u.roles = concat((select roles from User usr where usr.username = :username), ',', :role) where username = :username")
    int addRole(@Param("username") String username, @Param("role") String role);
}

package com.owle.OwleAPI.repositories;

import com.owle.OwleAPI.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}

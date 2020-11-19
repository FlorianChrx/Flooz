package com.owle.OwleAPI.repositories;

import com.owle.OwleAPI.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, String> {
}

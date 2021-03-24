package com.owle.OwleAPI.repositories;

import com.owle.OwleAPI.ids.GroupId;
import com.owle.OwleAPI.model.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, GroupId> {
}

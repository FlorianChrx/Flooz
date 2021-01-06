package com.owle.OwleAPI.model;

import com.owle.OwleAPI.ids.GroupId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@IdClass(GroupId.class)
public class Group {

    @Id
    public int id;

    @Id
    public User user;

    public Group(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public Group() {
    }
}

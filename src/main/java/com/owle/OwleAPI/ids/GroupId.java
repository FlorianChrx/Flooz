package com.owle.OwleAPI.ids;

import com.owle.OwleAPI.model.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GroupId implements Serializable {
    private int id;
    private User user;

    public GroupId(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public GroupId() {
    }
}

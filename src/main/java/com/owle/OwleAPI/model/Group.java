package com.owle.OwleAPI.model;

import com.owle.OwleAPI.ids.GroupId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (getId() != group.getId()) return false;
        return getUser().equals(group.getUser());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUser().hashCode();
        return result;
    }
}

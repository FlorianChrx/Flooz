package com.owle.OwleAPI.ids;

import com.owle.OwleAPI.model.User;

import java.io.Serializable;

public class GroupId implements Serializable {
    private int id;
    private User user;

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

    public GroupId(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public GroupId() {
    }
}

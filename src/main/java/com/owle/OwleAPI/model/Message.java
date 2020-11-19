package com.owle.OwleAPI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Message {
    @Id
    private String name;
    private String msg;

    public Message(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public Message() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return getName().equals(message.getName()) &&
                getMsg().equals(message.getMsg());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMsg());
    }
}

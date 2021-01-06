package com.owle.OwleAPI.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@EqualsAndHashCode
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
}

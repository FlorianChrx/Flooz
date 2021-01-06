package com.owle.OwleAPI.model;

import com.owle.OwleAPI.ids.GroupId;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(GroupId.class)
public class Group {
    @Id
    public int id;

    @Id
    public User user;
}

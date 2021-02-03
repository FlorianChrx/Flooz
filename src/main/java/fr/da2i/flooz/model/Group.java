package fr.da2i.flooz.model;

import fr.da2i.flooz.ids.GroupId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(GroupId.class)
@Table(name = "groups")
public class Group {
    @Id
    public int id;

    @Id
    public User user;
}

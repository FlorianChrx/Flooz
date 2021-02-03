package fr.da2i.flooz.ids;

import fr.da2i.flooz.model.User;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupId implements Serializable {
    private int id;
    private User user;
}

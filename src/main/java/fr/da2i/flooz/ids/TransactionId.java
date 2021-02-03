package fr.da2i.flooz.ids;

import fr.da2i.flooz.model.Group;
import fr.da2i.flooz.model.User;
import lombok.*;

import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionId implements Serializable {
    private Group tgroup;
    private User spender;
}

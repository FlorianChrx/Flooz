package fr.da2i.flooz.ids;

import fr.da2i.flooz.model.Group;
import fr.da2i.flooz.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionId implements Serializable {
    private Group tgroup;
    private User spender;
}

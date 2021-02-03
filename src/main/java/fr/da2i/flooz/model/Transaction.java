package fr.da2i.flooz.model;

import fr.da2i.flooz.ids.GroupId;
import fr.da2i.flooz.ids.TransactionId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(TransactionId.class)
public class Transaction {
    @Id
    private GroupId tgroup;
    @Id
    private User spender;
    private Double amount;
}

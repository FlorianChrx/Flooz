package fr.da2i.flooz.model;

import fr.da2i.flooz.ids.TransactionId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(TransactionId.class)
public class Transaction {
    @Id
    @OneToOne
    private Group group;
    @Id
    @OneToOne
    private User spender;
    private Double amount;
}

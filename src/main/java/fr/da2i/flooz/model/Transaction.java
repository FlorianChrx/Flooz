package fr.da2i.flooz.model;

import fr.da2i.flooz.ids.TransactionId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
    @EmbeddedId
    private TransactionId id;
    private Double amount;
}

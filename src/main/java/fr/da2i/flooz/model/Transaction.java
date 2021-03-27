package fr.da2i.flooz.model;

import fr.da2i.flooz.ids.TransactionId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
    private Integer id;
    private Double amount;
    
    private Group group;
    
    private User user;
    
    
}

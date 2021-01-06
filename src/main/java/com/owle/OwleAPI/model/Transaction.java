package com.owle.OwleAPI.model;

import com.owle.OwleAPI.ids.TransactionId;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(TransactionId.class)
public class Transaction {
    @Id
    private Group group;
    @Id
    private User spender;
    private Double amount;
}

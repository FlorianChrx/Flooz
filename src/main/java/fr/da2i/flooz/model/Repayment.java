package fr.da2i.flooz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repayment {
    private User sender;
    private User receiver;
    private Double Amount;
}

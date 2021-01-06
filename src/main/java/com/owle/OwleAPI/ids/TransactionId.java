package com.owle.OwleAPI.ids;

import com.owle.OwleAPI.model.Group;
import com.owle.OwleAPI.model.User;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TransactionId {
    private Group group;
    private User spender;
}

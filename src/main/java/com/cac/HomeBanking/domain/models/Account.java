package com.cac.HomeBanking.domain.models;


import com.cac.HomeBanking.domain.models.User;
import lombok.Data;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    
    @ManyToOne
    private User owner;

}

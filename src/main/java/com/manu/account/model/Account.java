package com.manu.account.model;

import com.manu.account.enums.ACCOUNT_TYPE;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "_accounts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private ACCOUNT_TYPE accountType;

}

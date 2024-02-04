package com.example.demotest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Tpp_product_register {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="product_id")
    private Long product_id;
    @Column(name="type")
    private String type;
    @Column(name="account_id")
    private Long account_id;
    @Column(name="currency_code")
    private String currency_code;
    @Column(name="state")
    private String state;
}

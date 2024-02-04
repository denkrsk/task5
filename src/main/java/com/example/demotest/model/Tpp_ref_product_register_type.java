package com.example.demotest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tpp_ref_product_register_type {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internal_id;
    @Column(name="value")
    private String value;
    @Column(name="register_type_name")
    private String register_type_name;
    @Column(name="product_class_code")
    private String product_class_code;
    @Column(name="account_type")
    private String account_type;
}

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
public class Tpp_ref_product_class {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internal_id;
    @Column(name="value")
    private String value;
    @Column(name="gbl_code")
    private String gbl_code;
    @Column(name="gbl_name")
    private String gbl_name;
    @Column(name="product_row_code")
    private String product_row_code;
    @Column(name="product_row_name")
    private String product_row_name;
    @Column(name="subclass_code")
    private String subclass_code;
    @Column(name="subclass_name")
    private String subclass_name;
}

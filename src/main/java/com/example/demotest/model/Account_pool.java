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
public class Account_pool {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="branchCode")
    private String branchCode;
    @Column(name="currencyCode")
    private String currencyCode;
    @Column(name="mdmCode")
    private String mdmCode;
    @Column(name="priorityCode")
    private String priorityCode;
    @Column(name="registryTypeCode")
    private String registryTypeCode;
    @Column(name="accounts")
    private String accounts;

}

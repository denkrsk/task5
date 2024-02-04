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
public class Tpp_product {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="product_code_id")
    private Long product_code_id;
    @Column(name="client_id")
    private Long client_id;
    @Column(name="type")
    private String type;
    @Column(name="number")
    private String number;
    @Column(name="priority")
    private Long priority;
    @Column(name="date_of_conclusion")
    private Date date_of_conclusion;
    @Column(name="start_date_time")
    private Date start_date_time;
    @Column(name="end_date_time")
    private Date end_date_time;
    @Column(name="days")
    private Long days;
    @Column(name="penalty_rate")
    private Long penalty_rate;
    @Column(name="nso")
    private Long nso;
    @Column(name="threshold_amount")
    private Long threshold_amount;
    @Column(name="requlsite_type")
    private String requlsite_type;
    @Column(name="interest_rate_type")
    private String interest_rate_type;
    @Column(name="tax_rate")
    private Long tax_rate;
    @Column(name="reason_close")
    private String reason_close;
    @Column(name="state")
    private String state;
}

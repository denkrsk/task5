package com.example.demotest.app_query;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.HashMap;
import java.util.Objects;

@Getter
@Setter
public class Instance {
    private long instanceId;
    private String productType;
    private String productCode;
    private String registerType;
    private String mdmCode;
    private String contractNumber;
    private Date contractDate;
    private int priority;
    private double interestRatePenalty;
    private double minimBalance;
    private double thresholdAmount;
    private String accountingDetails;
    private String rateType;
    private double taxPercentageRate;
    private double technicalOverdraftLimitAmount;
    private int contractId;
    private String branchCode;
    private String isoCurrencyCode;
    private String urgencyCode;
    private int referenceCode;
    private HashMap<String, String> additionalProperties;
    private InstanceArrangement[] instanceArrangementList;

    public boolean vaildateField(){
        System.out.println("vaildateField this.priority = " + this.priority);;
        if (Objects.isNull(this.productType) | this.productType.isEmpty()) throw new IllegalArgumentException("Поле productType не может быть пустым.");
        if (Objects.isNull(this.productCode) | this.productCode.isEmpty()) throw new IllegalArgumentException("Поле productCode не может быть пустым.");
        if (Objects.isNull(this.registerType) | this.registerType.isEmpty()) throw new IllegalArgumentException("Поле registerType не может быть пустым.");
        if (Objects.isNull(this.mdmCode) | this.mdmCode.isEmpty()) throw new IllegalArgumentException("Поле mdmCode не может быть пустым.");
        if (Objects.isNull(this.contractNumber) | this.contractNumber.isEmpty()) throw new IllegalArgumentException("Поле contractNumber не может быть пустым.");
        if (Objects.isNull(this.contractDate)) throw new IllegalArgumentException("Поле contractDate не может быть пустым.");
        if (this.priority == 0) throw new IllegalArgumentException("Поле priority не может быть пустым.");
        if (this.contractId == 0) throw new IllegalArgumentException("Поле contractId не может быть пустым.");
        if (Objects.isNull(this.branchCode) | this.branchCode.isEmpty()) throw new IllegalArgumentException("Поле branchCode не может быть пустым.");
        if (Objects.isNull(this.isoCurrencyCode) | this.isoCurrencyCode.isEmpty()) throw new IllegalArgumentException("Поле isoCurrencyCode не может быть пустым.");
        if (Objects.isNull(this.urgencyCode) | this.urgencyCode.isEmpty()) throw new IllegalArgumentException("Поле urgencyCode не может быть пустым.");

        System.out.println("length agr = " + this.instanceArrangementList.length);
        return true;
    }
}

package com.example.demotest.app_query;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class InstanceArrangement {
    private String generalAgreementId;
    private String supplementaryAgreementId;
    private String arrangementType;
    private int shedulerJobId;
    private String number;
    private Date openingDate;
    private Date closingDate;
    private Date cancelDate;
    private int validityDuration;
    private String cancellationReason;
    private String status;
    private Date interestCalculationDate;
    private double interestRate;
    private double coefficient;
    private String coefficientAction;
    private double minimumInterestRate;
    private String minimumInterestRateCoeficient;
    private String minimumInterestRateCoeficientAction;
    private double maximaInterestRate;
    private double maximaInterestRateCoeficient;
    private String maximaInterestRateCoeficientAction;

}

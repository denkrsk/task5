package com.example.demotest.app_query;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Account {
    private long instanceId;
    private String registryTypeCode;
    private String accountType;
    private String currencyCode;
    private String branchCode;
    private String priorityCode;
    private String clientCode;
    private String trainRegion;
    private String counter;
    private String salesCode;

    public boolean vaildateField(){
        System.out.println("this.instanceId="+this.instanceId);
        if (Objects.isNull(this.instanceId) | this.instanceId == 0) throw new IllegalArgumentException("Поле instanceId не может быть пустым.");

        return true;
    }
}

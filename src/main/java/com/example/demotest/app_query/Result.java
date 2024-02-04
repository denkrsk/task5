package com.example.demotest.app_query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private int status;
    private String message;
    private ResAcc resAcc;
    private ResInst resInst;
}


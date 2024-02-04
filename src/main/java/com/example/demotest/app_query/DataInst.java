package com.example.demotest.app_query;

import com.example.demotest.model.Tpp_product_register;

public class DataInst {
    public String instanceId;
    Long[] registerId;

    public void setRegisterId(Long[] registerId) {
        this.registerId = registerId;
    }

    public DataInst(Long id) {
        this.instanceId = String.valueOf(id);
    }
}

package com.integrations.cict.dto;

import com.integrations.cict.model.PaymentDetail;

import java.io.Serializable;

public class PaymentDetailDTO extends GenericDTO implements Serializable {

    private PaymentDetail data;

    public PaymentDetailDTO(){

    }

    public PaymentDetail getData() {
        return data;
    }

    public void setData(PaymentDetail data) {
        this.data = data;
    }
}

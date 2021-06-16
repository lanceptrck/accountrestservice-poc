package com.integrations.cict.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class PaymentDetail implements Serializable {

    private Integer months_arrear;
    private Date due_date;
    private String currency_code;
    private Double current_ar;

}

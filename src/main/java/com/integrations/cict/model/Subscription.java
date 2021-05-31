package com.integrations.cict.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class Subscription implements Serializable {

    private String item_code;
    private String serial_no;
    private String mac_address;
    private String subscription;
    private String product_id;
    private String currency_code;
    private Double mrc;

}

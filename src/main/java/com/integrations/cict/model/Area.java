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
public class Area implements Serializable {

    private String municipality;
    private String province;
    private String service_address;

    @Override
    public String toString() {
        return "Area{" +
                "municipality='" + municipality + '\'' +
                ", province='" + province + '\'' +
                ", service_address='" + service_address + '\'' +
                '}';
    }
}

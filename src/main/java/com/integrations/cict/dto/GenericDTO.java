package com.integrations.cict.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.integrations.cict.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sun.net.www.content.text.Generic;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Getter @Setter
public class GenericDTO<T> {

    private Status status;
    private Integer responseCode;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }
}

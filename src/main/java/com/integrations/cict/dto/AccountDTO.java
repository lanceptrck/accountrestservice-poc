package com.integrations.cict.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.integrations.cict.model.Account;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDTO extends GenericDTO implements Serializable {

    private Account data;

    public AccountDTO(){

    }

    public Account getData() {
        return data;
    }

    public void setData(Account data) {
        this.data = data;
    }
}

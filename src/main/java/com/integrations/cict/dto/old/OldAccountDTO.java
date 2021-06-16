package com.integrations.cict.dto.old;

import com.integrations.cict.model.Account;

import java.io.Serializable;

public class OldAccountDTO extends OldBaseDTO implements Serializable {

    private Account data;

    public OldAccountDTO() {

    }

    public Account getData() {
        return data;
    }

    public void setData(Account data) {
        this.data = data;
    }
}

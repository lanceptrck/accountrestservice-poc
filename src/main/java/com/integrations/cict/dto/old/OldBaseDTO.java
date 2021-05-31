package com.integrations.cict.dto.old;

import com.integrations.cict.model.Error;

import java.io.Serializable;
import java.util.List;

public class OldBaseDTO implements Serializable {

    private Boolean success;
    private List<Error> errors;

    public OldBaseDTO(){

    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}

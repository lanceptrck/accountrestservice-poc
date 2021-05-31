package com.integrations.cict.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class OutageStatus {

    private boolean is_online;
    private Date as_of;

}

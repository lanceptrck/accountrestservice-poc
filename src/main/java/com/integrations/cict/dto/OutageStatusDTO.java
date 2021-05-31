package com.integrations.cict.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.integrations.cict.model.OutageStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @NoArgsConstructor
public class OutageStatusDTO extends GenericDTO {
    private OutageStatus outageStatus;
}

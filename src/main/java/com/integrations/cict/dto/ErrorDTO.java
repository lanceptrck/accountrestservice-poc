package com.integrations.cict.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.integrations.cict.exception.ExceptionResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @NoArgsConstructor
public class ErrorDTO extends GenericDTO {

    private ExceptionResponse error;



}

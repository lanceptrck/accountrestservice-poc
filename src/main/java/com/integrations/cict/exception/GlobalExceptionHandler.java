package com.integrations.cict.exception;

import com.integrations.cict.dto.ErrorDTO;
import com.integrations.cict.model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<ErrorDTO> handleInvalidCredentialsException(AccountNotFoundException ex) {
        ErrorDTO dto = new ErrorDTO();
        dto.setStatus(Status.FAILURE);
        dto.setError(buildExceptionResponse(ex, "Account doesn't exist"));
        dto.setResponseCode(HttpStatus.UNAUTHORIZED.value());

        return new ResponseEntity<ErrorDTO>(dto, HttpStatus.UNAUTHORIZED);
    }

    private ExceptionResponse buildExceptionResponse(Exception ex, String errorCode) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorMessage(ex.getMessage());
        response.setErrorCode(errorCode);
        response.setTimestamp(LocalDateTime.now());
        return response;
    }


}

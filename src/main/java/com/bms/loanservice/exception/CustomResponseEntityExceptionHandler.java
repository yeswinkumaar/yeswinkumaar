package com.bms.loanservice.exception;


import com.bms.loanservice.common.APIError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private APIError apiError;

    @ExceptionHandler(value = {IllegalStateException.class})
    protected ResponseEntity<Object> handleNotFoundException(IllegalStateException ex){
        apiError = new APIError(HttpStatus.NOT_FOUND.name(),HttpStatus.NOT_FOUND.value(),ex.getMessage());

        return ResponseEntity.
                status(apiError.getStatusCode())
                .body(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        apiError = new APIError(status.name(),status.value(),ex.getMessage());

        return ResponseEntity
                .status(apiError.getStatusCode())
                .body(apiError);
    }
}

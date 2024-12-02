package com.ivan.ecommerce.rest.advice;

import com.ivan.ecommerce.contract.model.ErrorDTO;
import com.ivan.ecommerce.core.model.exception.InternalException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class, InternalException.class})
    protected ResponseEntity<ErrorDTO> handleGenericException(Exception ex, WebRequest request) {
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorDTO error = new ErrorDTO().status(String.valueOf(status.value())).description(ex.getMessage());
        printStackTrace(ex);
        return ResponseEntity.status(status).body(error);
    }

    private void printStackTrace(Throwable e) {
        log.error(ExceptionUtils.getStackTrace(e));
    }
}

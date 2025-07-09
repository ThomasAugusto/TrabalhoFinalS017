package org.s017.accountservice.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> illegalArgumentException(IllegalArgumentException exception){
        logger.warn(exception.getMessage());
        return ResponseEntity.badRequest().body("Requisição inválida. Verifique os dados informados");
    }
}

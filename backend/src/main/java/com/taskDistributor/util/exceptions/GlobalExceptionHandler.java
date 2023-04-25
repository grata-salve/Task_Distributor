package com.taskDistributor.util.exceptions;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<Object> exception(GlobalException e) {
    return ResponseEntity.status(e.getHttpStatus())
        .body(Map.of("errorCode", e.getErrorCode(), "errorMessage", e.getErrorMessage()));
  }
}

package com.taskDistributor.util.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class GlobalException extends RuntimeException {

  @JsonIgnore
  protected final HttpStatus httpStatus;
  protected final String errorCode;
  protected final String errorMessage;

  public GlobalException(HttpStatus httpStatus, String errorCode, String errorMessage) {
    this.httpStatus = httpStatus;
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }
}

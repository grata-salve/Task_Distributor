package com.taskDistributor.util.exceptions;

import org.springframework.http.HttpStatus;

public class UserExistsException extends GlobalException {

  public UserExistsException() {
    super(HttpStatus.FORBIDDEN, "user_already_exists",
        "You are already registered");
  }
}

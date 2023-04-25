package com.taskDistributor.util.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GlobalException {

  public UserNotFoundException() {
    super(HttpStatus.FORBIDDEN, "user_not_found",
        "There is no such User");
  }
}

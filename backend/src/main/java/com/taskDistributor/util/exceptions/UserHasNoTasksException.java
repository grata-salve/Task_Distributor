package com.taskDistributor.util.exceptions;

import org.springframework.http.HttpStatus;

public class UserHasNoTasksException extends GlobalException {

  public UserHasNoTasksException() {
    super(HttpStatus.FORBIDDEN, "user_tasks_not_found",
        "The User has no assigned tasks yet");
  }
}

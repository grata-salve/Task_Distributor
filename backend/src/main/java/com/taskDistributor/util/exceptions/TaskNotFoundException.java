package com.taskDistributor.util.exceptions;

import org.springframework.http.HttpStatus;

public class TaskNotFoundException extends GlobalException {

  public TaskNotFoundException() {
    super(HttpStatus.FORBIDDEN, "task_not_found",
        "There is no such Task");
  }
}

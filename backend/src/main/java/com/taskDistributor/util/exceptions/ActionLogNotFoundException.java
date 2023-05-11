package com.taskDistributor.util.exceptions;

import org.springframework.http.HttpStatus;

public class ActionLogNotFoundException extends GlobalException {

  public ActionLogNotFoundException() {
    super(HttpStatus.FORBIDDEN, "actionLogs_not_found",
        "There is no such Log");
  }
}

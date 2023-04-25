package com.taskDistributor.util.exceptions;

import org.springframework.http.HttpStatus;

public class ActionLogsNotFoundException extends GlobalException {

  public ActionLogsNotFoundException() {
    super(HttpStatus.FORBIDDEN, "actionLogs_not_found",
        "There is no such Log");
  }
}

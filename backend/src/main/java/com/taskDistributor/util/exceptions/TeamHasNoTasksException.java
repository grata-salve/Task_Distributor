package com.taskDistributor.util.exceptions;

import org.springframework.http.HttpStatus;

public class TeamHasNoTasksException extends GlobalException {

  public TeamHasNoTasksException() {
    super(HttpStatus.FORBIDDEN, "team_tasks_not_found",
        "The Team has no assigned tasks yet");
  }
}

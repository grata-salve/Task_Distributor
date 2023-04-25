package com.taskDistributor.util.exceptions;

import org.springframework.http.HttpStatus;

public class TeamNotFoundException extends GlobalException {

  public TeamNotFoundException() {
    super(HttpStatus.FORBIDDEN, "team_not_found",
        "There is no such Team");
  }
}

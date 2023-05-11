package com.taskDistributor.controllers;

import com.taskDistributor.services.UserTaskService;
import com.taskDistributor.services.dtos.TaskDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

  private final UserTaskService userTaskService;

  @GetMapping("/userTasks/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public List<TaskDto> getUserTasks(@PathVariable Long userId) {
    return userTaskService.getUserTasks(userId);
  }

  @GetMapping("/teamTasks/{teamId}")
  @ResponseStatus(HttpStatus.OK)
  public List<TaskDto> getTeamTasks(@PathVariable Long teamId) {
    return userTaskService.getTeamTasks(teamId);
  }
}

package com.taskDistributor.controllers;

import com.taskDistributor.services.TaskService;
import com.taskDistributor.services.UserTasksService;
import com.taskDistributor.services.dtos.TaskDto;
import com.taskDistributor.services.dtos.UserTasksDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

  private final TaskService taskService;
  private final UserTasksService userTasksService;

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public TaskDto createTask(@RequestBody TaskDto taskDto) {
    return taskService.createTask(taskDto);
  }

  @GetMapping("/get/{taskId}")
  @ResponseStatus(HttpStatus.OK)
  public TaskDto getTask(@PathVariable Long taskId) {
    return taskService.getTaskById(taskId);
  }

  @PutMapping("/edit/{taskId}")
  @ResponseStatus(HttpStatus.OK)
  public TaskDto editTask(@RequestBody TaskDto taskDto,
      @PathVariable Long taskId) {
    return taskService.editTask(taskDto, taskId);
  }

  @DeleteMapping("/delete/{taskId}")
  @ResponseStatus(HttpStatus.OK)
  public TaskDto deleteTeam(@PathVariable Long taskId) {
    return taskService.deleteTask(taskId);
  }

  @PostMapping("/assignMember")
  @ResponseStatus(HttpStatus.CREATED)
  public UserTasksDto assignMember(@RequestBody UserTasksDto userTasksDto) {
    return userTasksService.assignMember(userTasksDto);
  }

  @PutMapping("/complete/{taskId}/{status}")
  @ResponseStatus(HttpStatus.OK)
  public TaskDto changeTaskStatus(@PathVariable Long taskId,
      @PathVariable String status) {
    return taskService.changeTaskStatus(taskId, status);
  }
}

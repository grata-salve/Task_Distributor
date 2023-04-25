package com.taskDistributor.services;

import com.taskDistributor.models.Task;
import com.taskDistributor.models.enums.Action;
import com.taskDistributor.models.enums.Status;
import com.taskDistributor.repositories.TaskRepository;
import com.taskDistributor.services.dtos.TaskDto;
import com.taskDistributor.services.dtos.mappers.TaskMapper;
import com.taskDistributor.util.exceptions.TaskNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskService {

  private final TaskRepository taskRepository;
  private final ActionLogsService actionLogsService;
  private final TaskMapper taskMapper;

  public TaskDto createTask(TaskDto taskDto) {
    Task task = taskRepository.save(taskMapper.toModel(taskDto));
    actionLogsService.saveLogs(task, Action.CREATED);
    return taskMapper.toDto(task);
  }

  @Transactional(readOnly = true)
  public TaskDto getTaskById(Long taskId) {
    Task task = taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    return taskMapper.toDto(task);
  }

  //TODO: update
  @Transactional
  public TaskDto editTask(TaskDto taskDto, Long taskId) {
    Task task = taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    task.setTaskName(taskDto.getTaskName());
    task.setDescription(taskDto.getDescription());
    task.setCreationDate(taskDto.getCreationDate());
    task.setStatus(taskDto.getStatus());
    actionLogsService.saveLogs(task, Action.EDITED);
    return taskMapper.toDto(task);
  }

  public TaskDto deleteTask(Long taskId) {
    Task task = taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    taskRepository.deleteById(taskId);
    actionLogsService.saveLogs(task, Action.DELETED);
    return taskMapper.toDto(task);
  }

  public TaskDto changeTaskStatus(Long taskId, String status) {
    Task task = taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    task.setStatus(Status.valueOf(status.toUpperCase()));
    actionLogsService.saveLogs(task, Action.STATUS_CHANGED);
    return taskMapper.toDto(taskRepository.save(task));
  }
}

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
  private final ActionLogService actionLogService;
  private final TaskMapper taskMapper;

  public TaskDto createTask(TaskDto taskDto) {
    Task task = taskRepository.save(taskMapper.toModel(taskDto));
    actionLogService.saveLogs(task, Action.CREATED);
    return taskMapper.toDto(task);
  }

  @Transactional(readOnly = true)
  public TaskDto getTaskById(Long taskId) {
    Task task = taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    return taskMapper.toDto(task);
  }

  @Transactional
  public TaskDto updateTask(Task task) {
    actionLogService.saveLogs(task, Action.UPDATED);
    return taskMapper.toDto(taskRepository.save(task));
  }

  public TaskDto deleteTask(Long taskId) {
    Task task = taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    taskRepository.deleteById(taskId);
    actionLogService.saveLogs(task, Action.DELETED);
    return taskMapper.toDto(task);
  }

  //TODO: ???
  public TaskDto changeTaskStatus(Long taskId, String status) {
    Task task = taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    task.setStatus(Status.valueOf(status.toUpperCase()));
    actionLogService.saveLogs(task, Action.STATUS_CHANGED);
    return taskMapper.toDto(taskRepository.save(task));
  }
}

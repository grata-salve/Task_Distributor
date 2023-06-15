package com.taskDistributor.services;

import com.taskDistributor.models.Task;
import com.taskDistributor.models.UserTask;
import com.taskDistributor.models.enums.Action;
import com.taskDistributor.repositories.UserTaskRepository;
import com.taskDistributor.services.dtos.TaskDto;
import com.taskDistributor.services.dtos.UserTaskDto;
import com.taskDistributor.services.dtos.mappers.TaskMapper;
import com.taskDistributor.services.dtos.mappers.UserTaskMapper;
import com.taskDistributor.util.exceptions.TeamHasNoTasksException;
import com.taskDistributor.util.exceptions.UserHasNoTasksException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserTaskService {

  private final UserTaskRepository userTaskRepository;
  private final ActionLogService actionLogService;
  private final UserTaskMapper userTaskMapper;
  private final TaskMapper taskMapper;

  @Transactional
  public UserTaskDto assignMember(UserTaskDto userTaskDto) {
    UserTask userTask = userTaskMapper.toModel(userTaskDto);
    actionLogService.saveLogs(userTask.getTask(), Action.MEMBER_ASSIGNED);
    return userTaskMapper.toDto(userTaskRepository.save(userTask));
  }

  @Transactional(readOnly = true)
  public List<TaskDto> getUserTasks(Long userId) {
    List<Task> userTasks = userTaskRepository.findAllTasksByUserId(userId).orElseThrow(
        UserHasNoTasksException::new);
    return taskMapper.toTaskDtos(userTasks);
  }

  @Transactional(readOnly = true)
  public List<TaskDto> getTeamTasks(Long teamId) {
    List<Task> userTasks = userTaskRepository.findAllTasksByTeamId(teamId).orElseThrow(
        TeamHasNoTasksException::new);
    return taskMapper.toTaskDtos(userTasks);
  }
}

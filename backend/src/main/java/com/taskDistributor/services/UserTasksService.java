package com.taskDistributor.services;

import com.taskDistributor.models.Task;
import com.taskDistributor.models.UserTasks;
import com.taskDistributor.models.enums.Action;
import com.taskDistributor.repositories.UserTasksRepository;
import com.taskDistributor.services.dtos.TaskDto;
import com.taskDistributor.services.dtos.UserTasksDto;
import com.taskDistributor.services.dtos.mappers.TaskMapper;
import com.taskDistributor.services.dtos.mappers.UserTasksMapper;
import com.taskDistributor.util.exceptions.TeamHasNoTasksException;
import com.taskDistributor.util.exceptions.UserHasNoTasksException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserTasksService {

  private final UserTasksRepository userTasksRepository;
  private final ActionLogsService actionLogsService;
  private final UserTasksMapper userTasksMapper;
  private final TaskMapper taskMapper;

  public UserTasksDto assignMember(UserTasksDto userTasksDto) {
    UserTasks userTasks = userTasksMapper.toModel(userTasksDto);
    actionLogsService.saveLogs(userTasks.getTask(), Action.MEMBER_ASSIGNED);
    return userTasksMapper.toDto(userTasksRepository.save(userTasks));
  }

  @Transactional(readOnly = true)
  public List<TaskDto> getUserTasks(Long userId) {
    List<Task> userTasks = userTasksRepository.findAllTasksByUserId(userId).orElseThrow(
        UserHasNoTasksException::new);
    return taskMapper.toTaskDtos(userTasks);
  }

  @Transactional(readOnly = true)
  public List<TaskDto> getTeamTasks(Long teamId) {
    List<Task> userTasks = userTasksRepository.findAllTasksByTeamId(teamId).orElseThrow(
        TeamHasNoTasksException::new);
    return taskMapper.toTaskDtos(userTasks);
  }
}

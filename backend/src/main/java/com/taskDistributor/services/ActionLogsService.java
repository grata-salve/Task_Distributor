package com.taskDistributor.services;

import com.taskDistributor.models.ActionLogs;
import com.taskDistributor.models.Task;
import com.taskDistributor.models.User;
import com.taskDistributor.models.enums.Action;
import com.taskDistributor.repositories.ActionLogsRepository;
import com.taskDistributor.services.dtos.ActionLogsDto;
import com.taskDistributor.services.dtos.mappers.ActionLogsMapper;
import com.taskDistributor.util.exceptions.ActionLogsNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ActionLogsService {

  private final ActionLogsRepository actionLogsRepository;
  private final ActionLogsMapper actionLogsMapper;

  @Transactional(readOnly = true)
  public ActionLogsDto getActionLogsById(Long actionLogsId) {
    ActionLogs actionLogs = actionLogsRepository.findById(actionLogsId).orElseThrow(
        ActionLogsNotFoundException::new);
    return actionLogsMapper.toDto(actionLogs);
  }

  @Transactional(readOnly = true)
  public List<ActionLogsDto> getLogsByUserId(Long userId) {
    List<ActionLogs> actionLogs = actionLogsRepository.findAllByUserId(userId)
        .orElseThrow(ActionLogsNotFoundException::new);
    return actionLogsMapper.toActionLogsDtos(actionLogs);
  }

  @Transactional(readOnly = true)
  public List<ActionLogsDto> getLogsByTaskId(Long taskId) {
    List<ActionLogs> actionLogs = actionLogsRepository.findAllByTaskId(taskId)
        .orElseThrow(ActionLogsNotFoundException::new);
    return actionLogsMapper.toActionLogsDtos(actionLogs);
  }

  @Transactional
  public void saveLogs(Task task, Action action) {
    User user = (User) SecurityContextHolder.getContext().
        getAuthentication().getPrincipal();
    ActionLogsDto actionLogsDto = new ActionLogsDto(task, user, action, LocalDateTime.now());
    actionLogsRepository.save(actionLogsMapper.toModel(actionLogsDto));
  }
}

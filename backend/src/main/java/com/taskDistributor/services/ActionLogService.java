package com.taskDistributor.services;

import com.taskDistributor.models.ActionLog;
import com.taskDistributor.models.Task;
import com.taskDistributor.models.User;
import com.taskDistributor.models.enums.Action;
import com.taskDistributor.repositories.ActionLogRepository;
import com.taskDistributor.services.dtos.ActionLogDto;
import com.taskDistributor.services.dtos.mappers.ActionLogMapper;
import com.taskDistributor.util.exceptions.ActionLogNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ActionLogService {

  private final ActionLogRepository actionLogRepository;
  private final ActionLogMapper actionLogMapper;

  @Transactional(readOnly = true)
  public ActionLogDto getActionLogsById(Long actionLogsId) {
    ActionLog actionLog = actionLogRepository.findById(actionLogsId).orElseThrow(
        ActionLogNotFoundException::new);
    return actionLogMapper.toDto(actionLog);
  }

  @Transactional(readOnly = true)
  public List<ActionLogDto> getLogsByUserId(Long userId) {
    List<ActionLog> actionLogs = actionLogRepository.findAllByUserId(userId)
        .orElseThrow(ActionLogNotFoundException::new);
    return actionLogMapper.toActionLogsDtos(actionLogs);
  }

  @Transactional(readOnly = true)
  public List<ActionLogDto> getLogsByTaskId(Long taskId) {
    List<ActionLog> actionLogs = actionLogRepository.findAllByTaskId(taskId)
        .orElseThrow(ActionLogNotFoundException::new);
    return actionLogMapper.toActionLogsDtos(actionLogs);
  }

  //TODO: mapper
  @Transactional
  public void saveLogs(Task task, Action action) {
    User user = (User) SecurityContextHolder.getContext().
        getAuthentication().getPrincipal();
    ActionLogDto actionLogDto = new ActionLogDto(task, user, action, LocalDateTime.now());
    actionLogRepository.save(actionLogMapper.toModel(actionLogDto));
  }
}

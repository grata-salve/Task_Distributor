package com.taskDistributor.services.dtos;

import com.taskDistributor.models.Task;
import com.taskDistributor.models.User;
import com.taskDistributor.models.enums.Action;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.taskDistributor.models.ActionLogs} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionLogsDto implements Serializable {

  private Task task;
  private User user;
  @NotNull
  private Action action;
  @NotNull
  private LocalDateTime actionDateTime;
}
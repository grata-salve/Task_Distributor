package com.taskDistributor.services.dtos;

import com.taskDistributor.models.Task;
import com.taskDistributor.models.User;
import com.taskDistributor.models.UserTask;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link UserTask} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTaskDto implements Serializable {

  @NotNull
  private User user;
  @NotNull
  private Task task;
  private LocalDateTime assignDate;
}
package com.taskDistributor.services.dtos;

import com.taskDistributor.models.Team;
import com.taskDistributor.models.enums.Status;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.taskDistributor.models.Task} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto implements Serializable {

  private Team team;
  @NotBlank
  private String taskName;
  private String description;
  private LocalDateTime deadline;
  private Status status;
}
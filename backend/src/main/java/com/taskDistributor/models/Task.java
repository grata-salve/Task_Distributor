package com.taskDistributor.models;

import com.taskDistributor.models.enums.Status;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task extends AbstractIdentifiable {

  @ManyToOne
  private Team team;

  @NotBlank
  private String taskName;

  private String description;

  private Status status;

  private LocalDateTime deadline;
}

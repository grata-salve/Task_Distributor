package com.taskDistributor.models;

import com.taskDistributor.models.enums.Status;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

  @NotNull
  private LocalDateTime creationDate;

  private Status status;

  @PrePersist
  public void prePersist() {
    this.creationDate = LocalDateTime.now(ZoneOffset.UTC);
  }

  // TODO: deadline(?)
}

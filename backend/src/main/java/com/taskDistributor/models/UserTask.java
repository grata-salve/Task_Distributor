package com.taskDistributor.models;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_tasks")
public class UserTask extends AbstractIdentifiable {

  @ManyToOne
  @NotNull
  private User user;

  @ManyToOne
  @NotNull
  private Task task;

  @NotNull
  private LocalDateTime assignDate;

  @PrePersist
  public void prePersist() {
    this.assignDate = LocalDateTime.now(ZoneOffset.UTC);
  }
}

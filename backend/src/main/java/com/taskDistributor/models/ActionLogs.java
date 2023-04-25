package com.taskDistributor.models;

import com.taskDistributor.models.enums.Action;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "action_logs")
public class ActionLogs extends AbstractIdentifiable {

  @ManyToOne
  private Task task;

  @ManyToOne
  private User user;

  @NotNull
  private Action action;

  @NotNull
  private LocalDateTime actionDateTime;

  @PrePersist
  public void prePersist() {
    this.actionDateTime = LocalDateTime.now(ZoneOffset.UTC);
  }
}

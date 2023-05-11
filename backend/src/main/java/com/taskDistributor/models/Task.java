package com.taskDistributor.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.taskDistributor.models.enums.Status;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
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

//  @Column(updatable = false)
//  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//  private LocalDateTime creationDate;

  private Status status;

  private LocalDateTime deadline;
//
//  @PrePersist
//  public void prePersist() {
//    this.creationDate = LocalDateTime.now(ZoneOffset.UTC);
//  }

}

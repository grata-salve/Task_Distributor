package com.taskDistributor.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teams")
public class Team extends AbstractIdentifiable {

  @NotBlank
  private String teamName;

  private String description;
}


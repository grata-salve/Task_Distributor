package com.taskDistributor.models;

import com.taskDistributor.models.enums.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_teams")
public class UserTeam extends AbstractIdentifiable {

  @ManyToOne
  @NotNull
  private User user;

  @ManyToOne
  @NotNull
  private Team team;

  @Column
  @NotNull
  private Role role;
}

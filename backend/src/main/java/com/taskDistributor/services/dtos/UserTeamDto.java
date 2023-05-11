package com.taskDistributor.services.dtos;

import com.taskDistributor.models.Team;
import com.taskDistributor.models.User;
import com.taskDistributor.models.UserTeam;
import com.taskDistributor.models.enums.Role;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link UserTeam} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTeamDto implements Serializable {

  @NotNull
  private User user;
  @NotNull
  private Team team;
  @NotNull
  private Role role;
}
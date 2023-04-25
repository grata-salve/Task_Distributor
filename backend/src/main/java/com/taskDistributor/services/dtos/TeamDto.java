package com.taskDistributor.services.dtos;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.taskDistributor.models.Team} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {

  @NotBlank
  private String teamName;
  private String description;
}
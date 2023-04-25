package com.taskDistributor.services.dtos;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.taskDistributor.models.User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

  @NotBlank
  private String firstname;
  @NotBlank
  private String lastname;
  @NotBlank
  @Email
  private String email;
}
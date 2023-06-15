package com.taskDistributor.models.auth;

import com.taskDistributor.models.AbstractIdentifiable;
import com.taskDistributor.models.User;
import com.taskDistributor.models.enums.TokenType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tokens")
public class Token extends AbstractIdentifiable {

  @Column(unique = true)
  private String token;

  @Enumerated(EnumType.STRING)
  private TokenType tokenType = TokenType.BEARER;

  private boolean revoked;

  private boolean expired;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}

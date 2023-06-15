package com.taskDistributor.services;

import com.taskDistributor.models.User;
import com.taskDistributor.models.auth.Token;
import com.taskDistributor.models.enums.TokenType;
import com.taskDistributor.repositories.TokenRepository;
import com.taskDistributor.repositories.UserRepository;
import com.taskDistributor.security.TokenProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {

  private final TokenRepository tokenRepository;
  private final TokenProvider tokenProvider;
  private final UserRepository userRepository;

  private void saveUserToken(User user, String jwtToken) {
    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(User user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }

  public String tokenProcessing(Authentication authentication, String email) {
    var jwtToken = tokenProvider.createToken(authentication);
    var user = userRepository.findByEmail(email).orElseThrow();
    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
    return jwtToken;
  }
}

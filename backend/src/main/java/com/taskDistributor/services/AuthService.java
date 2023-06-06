package com.taskDistributor.services;

import com.taskDistributor.models.AuthProvider;
import com.taskDistributor.models.User;
import com.taskDistributor.payload.AuthResponse;
import com.taskDistributor.payload.LoginRequest;
import com.taskDistributor.payload.SignUpRequest;
import com.taskDistributor.repositories.UserRepository;
import com.taskDistributor.security.TokenProvider;
import com.taskDistributor.util.exceptions.BadRequestException;
import com.taskDistributor.util.exceptions.UserExistsException;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class AuthService {
//  private final UserRepository repository;
//  private final TokenRepository tokenRepository;
//  private final PasswordEncoder passwordEncoder;
//  private final JwtService jwtService;
//  private final AuthenticationManager authenticationManager;
//
//  public AuthenticationResponse register(RegisterRequest request) {
//    var user = User.builder()
//        .firstname(request.getFirstname())
//        .lastname(request.getLastname())
//        .email(request.getEmail())
//        .password(passwordEncoder.encode(request.getPassword()))
//        .build();
//    if (repository.findByEmail(user.getEmail()).isPresent()) {
//      throw new UserExistsException();
//    }
//    var savedUser = repository.save(user);
//    var jwtToken = jwtService.generateToken(user);
//    saveUserToken(savedUser, jwtToken);
//    return AuthenticationResponse.builder()
//        .token(jwtToken)
//        .build();
//  }
//
//  public AuthenticationResponse authenticate(AuthenticationRequest request) {
//    authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken(
//            request.getEmail(),
//            request.getPassword()
//        )
//    );
//    var user = repository.findByEmail(request.getEmail())
//        .orElseThrow();
//    var jwtToken = jwtService.generateToken(user);
//    revokeAllUserTokens(user);
//    saveUserToken(user, jwtToken);
//    return AuthenticationResponse.builder()
//        .token(jwtToken)
//        .build();
//  }
//
//  private void saveUserToken(User user, String jwtToken) {
//    var token = Token.builder()
//        .user(user)
//        .token(jwtToken)
//        .tokenType(TokenType.BEARER)
//        .expired(false)
//        .revoked(false)
//        .build();
//    tokenRepository.save(token);
//  }
//
//  private void revokeAllUserTokens(User user) {
//    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
//    if (validUserTokens.isEmpty())
//      return;
//    validUserTokens.forEach(token -> {
//      token.setExpired(true);
//      token.setRevoked(true);
//    });
//    tokenRepository.saveAll(validUserTokens);
//  }

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final TokenProvider tokenProvider;


  public AuthResponse login(LoginRequest request) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);
    return new AuthResponse(tokenProvider.createToken(authentication));
  }

  public URI signup(SignUpRequest request) {
    if (userRepository.existsByEmail(request.getEmail())) {
      throw new UserExistsException();
    }

    var user = User.builder()
        .name(request.getName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .provider(AuthProvider.local)
        .emailVerified(false)
        .build();

    User result = userRepository.save(user);

    return ServletUriComponentsBuilder
        .fromCurrentContextPath().path("/user/me")
        .buildAndExpand(result.getId()).toUri();
  }
}
package com.taskDistributor.services;

import com.taskDistributor.models.AuthProvider;
import com.taskDistributor.models.User;
import com.taskDistributor.payload.AuthResponse;
import com.taskDistributor.payload.LoginRequest;
import com.taskDistributor.payload.SignUpRequest;
import com.taskDistributor.repositories.UserRepository;
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

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;


  public AuthResponse login(LoginRequest request) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);

    return new AuthResponse(jwtService.tokenProcessing(authentication, request.getEmail()));
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
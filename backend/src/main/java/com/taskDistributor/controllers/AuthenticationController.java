package com.taskDistributor.controllers;

import com.taskDistributor.models.auth.AuthenticationRequest;
import com.taskDistributor.models.auth.AuthenticationResponse;
import com.taskDistributor.models.auth.RegisterRequest;
import com.taskDistributor.services.AuthenticationService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public AuthenticationResponse register(
      @RequestBody RegisterRequest request) {
    return service.register(request);
  }

  @PostMapping("/authenticate")
  @ResponseStatus(HttpStatus.OK)
  public AuthenticationResponse authenticate(
      @RequestBody AuthenticationRequest request) {
    return service.authenticate(request);
  }

  @GetMapping("/user")
  @ResponseStatus(HttpStatus.OK)
  public Object getUser(Authentication authentication) {
    return authentication.getPrincipal();
  }

  //TODO: ???
  @GetMapping("/google")
  @ResponseStatus(HttpStatus.OK)
  public Map<String, Object> currentUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
    return oAuth2AuthenticationToken.getPrincipal().getAttributes();
  }

}
package com.taskDistributor.controllers;

import com.taskDistributor.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthService service;
//
//  @PostMapping("/register")
//  @ResponseStatus(HttpStatus.CREATED)
//  public AuthenticationResponse register(
//      @RequestBody RegisterRequest request) {
//    return service.register(request);
//  }
//
//  @PostMapping("/authenticate")
//  @ResponseStatus(HttpStatus.OK)
//  public AuthenticationResponse authenticate(
//      @RequestBody AuthenticationRequest request) {
//    return service.authenticate(request);
//  }

//  @GetMapping("/user")
//  @ResponseStatus(HttpStatus.OK)
//  public Object getUser(Authentication authentication) {
//    return authentication.getPrincipal();
//  }
}
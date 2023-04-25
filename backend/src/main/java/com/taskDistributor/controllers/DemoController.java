package com.taskDistributor.controllers;

import com.taskDistributor.models.User;
import java.security.Principal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

  @GetMapping
  public ResponseEntity<String> sayHello(Authentication authentication) {
    User user = (User) authentication.getPrincipal();
    System.out.println(user.getId());

    return ResponseEntity.ok("Hello from secured endpoint");
  }

}
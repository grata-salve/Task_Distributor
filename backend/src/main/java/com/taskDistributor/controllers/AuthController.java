package com.taskDistributor.controllers;

import com.taskDistributor.payload.ApiResponse;
import com.taskDistributor.payload.AuthResponse;
import com.taskDistributor.payload.LoginRequest;
import com.taskDistributor.payload.SignUpRequest;
import com.taskDistributor.services.AuthService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return service.login(request);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpRequest request) {
        return ResponseEntity.created(service.signup(request))
                .body(new ApiResponse(true, "User registered successfully@"));
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public Object getUser(Authentication authentication) {
        return authentication.getPrincipal();
    }
}

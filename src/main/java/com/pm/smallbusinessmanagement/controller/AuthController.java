package com.pm.smallbusinessmanagement.controller;

import com.pm.smallbusinessmanagement.dto.JwtAuthResponse;
import com.pm.smallbusinessmanagement.dto.RefreshTokenRequest;
import com.pm.smallbusinessmanagement.dto.SignInRequest;
import com.pm.smallbusinessmanagement.dto.SignUpRequest;
import com.pm.smallbusinessmanagement.model.User;
import com.pm.smallbusinessmanagement.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authService.signup(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signin(@RequestBody SignInRequest signInRequest) {
        return ResponseEntity.ok(authService.signin(signInRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }
}
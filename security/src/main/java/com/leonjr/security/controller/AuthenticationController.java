package com.leonjr.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leonjr.security.request.AuthenticationRequest;
import com.leonjr.security.request.RegisterRequest;
import com.leonjr.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    /**
     * Create a new user and generate a token for it
     * 
     * @param request the request with the user data
     * @return AuthenticationResponse with the token
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    /**
     * 
     * Authenticate a user and generate a token for it
     * 
     * @param request the request with the user data
     * @return AuthenticationResponse with the token
     */
    @PostMapping("/signin")
    public ResponseEntity<?> signin(
            @RequestBody AuthenticationRequest request) {
        try {
            return ResponseEntity.ok(authenticationService.signin(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getLocalizedMessage());
        }
    }
}
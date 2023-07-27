package com.leonjr.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.leonjr.security.model.Role;
import com.leonjr.security.model.User;
import com.leonjr.security.repository.UserRepository;
import com.leonjr.security.request.AuthenticationRequest;
import com.leonjr.security.request.RegisterRequest;
import com.leonjr.security.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Create a new user and generate a token for it
     * 
     * @param request the request with the user data
     * @return AuthenticationResponse with the token
     */
    public AuthenticationResponse signup(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(
                        request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * Authenticate a user and generate a token for it
     * 
     * @param request the request with the user data
     * @return AuthenticationResponse with the token
     */
    public AuthenticationResponse signin(AuthenticationRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}

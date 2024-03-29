package com.leonjr.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leonjr.security.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    
    /**
     * Get the actual user logged in the application
     * 
     * @return UserDTO object with the user data
     */
    @GetMapping
    public ResponseEntity<?> getLoggedUser() {
        try {
            return ResponseEntity.ok(userService.getActualUser());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getLocalizedMessage());
        }
    }
}

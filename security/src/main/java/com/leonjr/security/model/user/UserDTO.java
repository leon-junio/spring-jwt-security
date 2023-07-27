package com.leonjr.security.model.user;

public record UserDTO (
    Integer id,
    String firstName,
    String lastName,
    String email,
    Role role
) {
    
}

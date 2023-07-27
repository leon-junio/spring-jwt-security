package com.leonjr.security.dto;

import com.leonjr.security.model.Role;

public record UserDTO (
    Integer id,
    String firstName,
    String lastName,
    String email,
    Role role
) {
}
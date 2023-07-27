package com.leonjr.security.service;

import java.util.function.Function;
import org.springframework.stereotype.Service;

import com.leonjr.security.dto.UserDTO;
import com.leonjr.security.model.User;

@Service
public class UserDtoMapper implements Function<User, UserDTO> {

    @Override
    /**
     * Convert a User object to a UserDTO object
     * 
     * @param user User object
     * @return UserDTO object
     */
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getRole());
    }
}
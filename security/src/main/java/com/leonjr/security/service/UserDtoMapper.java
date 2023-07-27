package com.leonjr.security.service;

import java.util.function.Function;
import org.springframework.stereotype.Service;
import com.leonjr.security.model.user.User;
import com.leonjr.security.model.user.UserDTO;

@Service
public class UserDtoMapper implements Function<User, UserDTO> {

    @Override
    public UserDTO apply(User user) {
       return new UserDTO(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getRole()
        );
    }
}
package com.leonjr.security.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.leonjr.security.dto.UserDTO;
import com.leonjr.security.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDtoMapper userDtoMapper;

    /**
     * Get the actual user logged in the application
     * 
     * @return UserDTO object with the user data
     */
    public UserDTO getActualUser() {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user != null ? userDtoMapper.apply(user) : null;
    }
}

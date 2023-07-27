package com.leonjr.security.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.leonjr.security.model.user.User;
import com.leonjr.security.model.user.UserDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDtoMapper userDtoMapper;

    public UserDTO getActualUser() {
        var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user != null ? userDtoMapper.apply(user) : null;
    }
}

package com.letsTest.service;

import com.letsTest.dto.userDto;
import com.letsTest.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

public interface UserService extends UserDetailsService {
    String save(userDto registration);
    userDto findUserByEmail(String email);
}

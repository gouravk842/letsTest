package com.letsTest.service;

import com.letsTest.dto.userDto;
import com.letsTest.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface UserService extends UserDetailsService {


    userDto FindById(@PathVariable(value = "userId")Long userId);
    String save(userDto registration);
    userDto findUserByEmail(String email);
}

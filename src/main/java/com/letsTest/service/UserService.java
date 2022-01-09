package com.letsTest.service;

import com.letsTest.dto.userDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserService extends UserDetailsService {

    userDto getUserById(Long id);

    String save(userDto registration);

    userDto findUserByEmail(String email);
}

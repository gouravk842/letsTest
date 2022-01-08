package com.letsTest.service;

import com.letsTest.dto.ResultDto;
import com.letsTest.dto.userDto;
import com.letsTest.entity.Result;
import com.letsTest.entity.User;
import com.letsTest.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    UserRepo userRepo;

    @Override
    public userDto FindById(Long userID) {
        Optional<User> user = userRepo.findById(userID);
        return modelMapper.map(user, userDto.class);
    }


    @Override
    public String save(userDto registration) {

        User newuser = new User();
        newuser = modelMapper.map(registration, new TypeToken<User>() {
        }.getType());
        newuser.setPassword(passwordEncoder.encode(registration.getPassword()));
        userRepo.save(newuser);
        return "Success";
    }

    @Override
    public userDto findUserByEmail(String email) {
        User existingUser = userRepo.findByEmail(email);
        if (existingUser != null) {
            userDto existingUserDto = modelMapper.map(existingUser, new TypeToken<userDto>() {
            }.getType());
            existingUserDto.setPassword(null);
            return existingUserDto;
        } else {
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), Collections.singleton(mapRolesToAuthorities(user.getRole())));
    }

    private SimpleGrantedAuthority mapRolesToAuthorities(String role) {
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
        return new SimpleGrantedAuthority(role);
    }

}

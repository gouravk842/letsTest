package com.letsTest.controller;

import com.google.gson.Gson;
import com.letsTest.dto.userDto;
import com.letsTest.repository.UserRepo;
import com.letsTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Gson gson;
    @Autowired
    UserRepo userRepo;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> adduser(@RequestBody userDto userRegistrationDto) {
        userDto existing = userService.findUserByEmail(userRegistrationDto.getEmail());
        if (existing == null) {
            userService.save(userRegistrationDto);
        }
        String msg = "Saved Successful";
        String msgJson = gson.toJson(msg);
        return new ResponseEntity<>(msgJson, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getProfile/{id}", method = RequestMethod.GET)
    @ResponseBody
    public userDto getUserById(@PathVariable(value = "id") Long id, Authentication auth) {
        Long uid = userRepo.getIdByEmail(auth.getName());

        return userService.getUserById(uid);
    }


}

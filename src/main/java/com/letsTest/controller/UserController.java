package com.letsTest.controller;

import com.google.gson.Gson;
import com.letsTest.dto.userDto;
import com.letsTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Gson gson;

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
}

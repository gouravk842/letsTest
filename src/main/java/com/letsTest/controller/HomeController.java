package com.letsTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView root() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("index.html");
        return mv;
    }@GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("home.html");
        return mv;
    }
}

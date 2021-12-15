package com.letsTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView root() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("index.html");
        return mv;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("home.html");
        return mv;
    }
    @ResponseBody
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("registration.html");
        return mv;
    }
}

package com.letsTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {
    @ResponseBody
    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("studentdashboard.html");
        return mv;
    }
}

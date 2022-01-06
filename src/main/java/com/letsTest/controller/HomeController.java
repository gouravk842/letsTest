package com.letsTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import javax.jws.WebParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView root() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("facultyHome.html");
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

    @GetMapping("/reviewQuestions")
    public ModelAndView reviewQuestions() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("reviewQuestions.html");
        return mv;
    }


    @GetMapping("/createQuiz")
    public ModelAndView createQuiz() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("createQuiz.html");
        return mv;
    }

    @GetMapping("/quizHistory")
    public ModelAndView quizHistory() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("quizHistory.html");
        return mv;
    }

    @GetMapping("/quizAnalysis")
    public ModelAndView quizAnalysis() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("quizAnalysis.html");
        return mv;
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("profile.html");
        return mv;
    }
}
